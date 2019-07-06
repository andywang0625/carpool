import React from 'react';
import { FormUserDetails, UserDetails } from '../../lib/registration/FormUserDetails';
import { PersonalDetails, FormPersonalDetails } from '../../lib/registration/FormPersonalDetails';
import { AppBar, Toolbar, IconButton } from '@material-ui/core';

export interface UserFormProps {}

export interface UserFormBaseProps {}

export interface UserFormState {
  step: number;
  firstName: string;
  lastName: string;
  email:string;
  gender: string;
  postalCode: string;
  phoneNumber: string;
}

export class UserForm extends React.PureComponent<UserFormProps & UserFormBaseProps, UserFormState> {
  constructor(props: UserFormProps & UserFormBaseProps){
    super(props);
    this.state = {
        step: 1,
        firstName: '',
        lastName: '',
        email:'',
        gender: '',
        postalCode: '',
        phoneNumber: ''
    }
  };

  prevStep = () => {
    const {step} = this.state;
    this.setState({
        step: step - 1
    });
  };

  nextStep = () => {
    const {step} = this.state;
    this.setState({
        step: step + 1
    });
  };

  updateUserDetailsForm = (form: UserDetails) => {
    console.log(this.state);
    const { firstName, lastName, email } = form;
    if(firstName) {
      this.setState({firstName: firstName});
    }
    if(lastName) {
      this.setState({lastName: lastName});
    }
    if(email) {
      this.setState({email: email});
    }
  }

  updatePersonalDetailsForm = (form: PersonalDetails) => {
    console.log(this.state);
    const { postalCode, phoneNumber, gender } = form;
    if(postalCode) {
      this.setState({postalCode: postalCode});
    }
    if(phoneNumber) {
      this.setState({phoneNumber: phoneNumber});
    }
    if(gender) {
      this.setState({gender: gender});
    }
  }

  render() {
    const { step } = this.state;
    switch (step) {
      case 1: 
        let userDetails: UserDetails = {
          firstName: this.state.firstName,
          lastName: this.state.lastName,
          email: this.state.email
        }
        return (
          <FormUserDetails
            nextStep = {this.nextStep}
            prevStep = {this.prevStep}
            updateForm = {this.updateUserDetailsForm}
            values = {userDetails}
          />
        );
      case 2:
        let personalDetails: PersonalDetails = {
          postalCode: this.state.postalCode,
          phoneNumber: this.state.phoneNumber,
          gender: this.state.gender
        }
        return ( 
          <FormPersonalDetails 
            nextStep = {this.nextStep}
            prevStep = {this.prevStep}
            updateForm = {this.updatePersonalDetailsForm}
            values = {personalDetails}
          />
        );
      default:
          return null
    }
  }
}