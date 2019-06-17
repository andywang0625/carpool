package com.web.carpool.controller;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import com.web.carpool.model.SharedModels.Address;
import com.web.carpool.model.SharedModels.Name;
import com.web.carpool.model.User;
import com.web.carpool.service.EmailService;
import com.web.carpool.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

@Controller
public class RegisterController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("emailService")
    private EmailService emailService;

    // Return registration form template
    @GetMapping(value = "/register")
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user, Name name, Address address) {
        modelAndView.addObject("name", name);
        modelAndView.addObject("user", user.setName(name).setAddress(address));
        System.out.println("user:" + user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    // Process form input data
    @PostMapping(value = "/register")
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, User user, @Valid Name name, Address address, BindingResult bindingResult, HttpServletRequest request) {

        user.setName(name).setAddress(address);

        System.out.println("user:" + user);

        // Lookup user in DB by email
        User userExists = userService.findUserByEmail(user.getEmail());

        System.out.println(userExists);

        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops! There is already a user registered with the email provided.");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {    // new user, so we create user and send confirmation email

            // Disable user until they click on confirmation link in email
            user.setActivated(false);

            // Generation random 36-character string token for confirmation link
            user.setConfirmationToken(UUID.randomUUID().toString());

            // Set up username to be the prefix of email by default
            user.setUsername(user.getEmail().split("@")[0]);

            userService.createUser(user);

            String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration Confirmation for Carpool Project");
            registrationEmail.setText("To confirm your e-mail address, please click the link below: \n"
                    + appUrl + "/confirm?token=" + user.getConfirmationToken());
            registrationEmail.setFrom("noreply@gmail.com");

            // TODO: Failed to send e-mail through google SMTP, disable temporarily.
//            emailService.sendEmail(registrationEmail);
            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
            modelAndView.addObject("confirmationLink", appUrl + "/confirm?token=" + user.getConfirmationToken());
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }

    // Process confirmation link
    @GetMapping(value = "/confirm")
    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {
        User user = userService.findUserByConfirmationToken(token);

        if (user == null) { // No token found in DB
            modelAndView.addObject("invalidToken", "Oops! This is an invalid confirmation link.");
        } else { // Token found
            modelAndView.addObject("confirmationToken", user.getConfirmationToken());
        }

        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    // Process confirmation link
    public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map requestParams, RedirectAttributes redir) {
        modelAndView.setViewName("confirm");

        Zxcvbn passwordCheck = new Zxcvbn();
        Strength strength = passwordCheck.measure(requestParams.get("password").toString());

        if (strength.getScore() < 5) {
            bindingResult.reject("password");

            redir.addFlashAttribute("errorMessage", "Your password is too weak. Choose a stronger one.");

            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));

            System.out.println(requestParams.get("token").toString());
            return modelAndView;
        }

        // Find the user associated with the reset token
        User user = userService.findUserByConfirmationToken(requestParams.get("token").toString());

        // Set new password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password").toString()));

        // Set user to activated
        user.setActivated(true);

        // Save create user
        userService.createUser(user);

        modelAndView.addObject("successMessage", "Your password has been set!");
        return modelAndView;
    }
}
