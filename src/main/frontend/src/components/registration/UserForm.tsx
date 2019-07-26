import React ,{ComponentState} from 'react';
// @ts-ignore
import SignUp from '../../lib/registration/SignUp.tsx';
// @ts-ignore
import SignIn from '../../lib/registration/SignIn.tsx';
// @ts-ignore
import Confirm from '/Users/shutingyang/HappyCoding/2019winter_AC_carpool_program/src/main/frontend/src/lib/registration/Confirm.tsx';
// @ts-ignore
import Success from '/Users/shutingyang/HappyCoding/2019winter_AC_carpool_program/src/main/frontend/src/lib/registration/Success.tsx';
// @ts-ignore
import { BrowserRouter, Route} from "react-router-dom";
// @ts-ignore
import Reset_Pwd from '../../lib/registration/Reset_Pwd.tsx';



export interface UserFormProps {}

export interface UserFormBaseProps {}

export interface UserFormState {
    firstName: string;
    lastName: string;
    email:string;
    gender: string;
    postalCode: string;
    phoneNumber: string;
    password: string;
    userName: string;
}

export class UserForm extends React.PureComponent<
    UserFormProps & UserFormBaseProps,
    UserFormState
> {
    constructor(props: any){
        super(props);
        this.state = {
            firstName: '',
            lastName: '',
            email:'',
            gender: '',
            postalCode: '',
            phoneNumber: '',
            password:'',
            userName: '',
        }
    };

    // validate = () => {
    //     let isError = false;
    //     const check = this.state
    //     const errors = {
    //         firstNameError:'',
    //         lastNameError: '',
    //         emailError: '',
    //         genderError: '',
    //         postalCodeError: '',
    //         phoneNumberError:'',
    //         passwordError:''
    //     };
    //     if(check.password===""){
    //         isError=true;
    //         errors.passwordError ="Please enter your password"
    //     }

    //     this.setState({
    //         ...this.state,
    //         ...errors
    //     });
    //     return isError;
    // }

    //proceed to next step
    // nextStep = () => {
    //     const hasErr = this.validate();
    //     if(!hasErr){
    //           const {step} = this.state;
    //           this.setState({
    //               step: step + 1
    //           });
    //     };
    // };

    //go back to prev step
    // prevStep = () => {
    //     const {step} = this.state;
    //     this.setState({
    //         step: step - 1
    //     });
    // };

    //bug here: the program doesn't go into this func. why???
    //might be event problem???
    handleRadioGroupChange = (event: React.ChangeEvent<unknown>, value: string): void =>{
        this.setState({gender : value});
    }


    handleChange = (event: React.ChangeEvent<HTMLInputElement>): void => {
        const {target: {name, value} } = event;
        this.setState({[name]: value} as ComponentState);
    }    

    render() {
        const {firstName, lastName, email, gender, postalCode, phoneNumber} = this.state;
        const values = { firstName, lastName, email, gender, postalCode, phoneNumber};

            return(
                <BrowserRouter>
                        <Route path="/signUp" 
                            render={()=> 
                            <SignUp
                                values={values}
                                handleChange = {this.handleChange}/> } />     

                        <Route path="/signIn" 
                            render={()=>
                            <SignIn
                                values={values}
                                handleChange = {this.handleChange}/> }/>

                        <Route path="/confirm" 
                            render= {()=>
                            <Confirm
                                values={values}
                                handleChange = {this.handleChange}/> }/>
                    
                        <Route path="/success" component={Success} />

                        <Route path="/reset_pwd" 
                            render={()=> 
                            <Reset_Pwd 
                                values={values} 
                            handleChange = {this.handleChange} />} />
                </BrowserRouter>

                );    
    }
}

export default UserForm