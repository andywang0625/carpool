import React, { ComponentState } from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

export interface UserDetails {
  firstName: string;
  lastName: string;
  email: string;
}

interface FormUserDetailsProps {
  nextStep: () => void;
  prevStep: () => void;
  values: UserDetails; 
  updateForm: (form: UserDetails) => void;
}

interface FormUserDetailsState {
  userDetails: UserDetails
}

export class FormUserDetails extends React.PureComponent<FormUserDetailsProps, FormUserDetailsState> {

  constructor(props: any) {
    super(props);
    this.state = { userDetails: props.values };
  }
  
  continue = ( e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
    e.preventDefault();
    this.props.updateForm(this.state.userDetails);
    this.props.nextStep();
  };

  handleChange = (name: keyof UserDetails) => (event: React.ChangeEvent<HTMLInputElement>) => {
    this.setState({userDetails: {
      [name]: event.target.value} as ComponentState
    })
  }
  
  render() {
    const { values } = this.props;
    return (
      <React.Fragment>
        <form>
          <TextField 
              label = "First Name"
              name = "firstName"
              margin = "normal"
              onChange= {this.handleChange('firstName')}
              value = {values.firstName}
          />
          <br/>
          <TextField 
              label = "Last Name"
              name = "lastName"
              margin = "normal"
              onChange= {this.handleChange('lastName')}
              defaultValue = {values.lastName}
          />
          <br/>
          <TextField 
              label = "Email"
              name = "email"
              margin = "normal"
              onChange= {this.handleChange('email')}
              defaultValue = {values.email}
          />
          <br/>
          <Button 
              variant="contained"
              color="primary"
              onClick = {this.continue}
          >Continue
          </Button>
        </form>
      </React.Fragment>
    );
  }
}