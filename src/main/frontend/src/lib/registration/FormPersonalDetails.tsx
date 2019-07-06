import React, { ComponentState } from "react";
import { TextField, RadioGroup, Radio, Button } from "@material-ui/core";

export interface PersonalDetails {
  postalCode: string;
  phoneNumber: string;
  gender: string;
}

export interface FormPersonalDetailsProps {
  nextStep: () => void;
  prevStep: () => void;
  values: PersonalDetails; 
  updateForm: (form: PersonalDetails) => void;
}

interface FormPersonalDetailsState {
  personalDetails: PersonalDetails
}

export class FormPersonalDetails extends React.PureComponent<FormPersonalDetailsProps, FormPersonalDetailsState> {
  constructor(props: any) {
    super(props);
    this.state = {
      personalDetails: {
        postalCode: props.postalCode,
        phoneNumber: props.phoneNumber,
        gender: props.gender
      }
    }
  }

  continue = ( e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
    e.preventDefault();
    this.props.updateForm(this.state.personalDetails);
    // this.props.nextStep();
  };

  back = ( e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
    e.preventDefault();
    this.props.prevStep();
  };

  handleTextChange = (name: keyof PersonalDetails) => (event: React.ChangeEvent<HTMLInputElement>) => {
    this.setState({personalDetails: {
      ...this.state.personalDetails,
      [name]: event.target.value} as ComponentState
    })
  }

  handleRadioGroupChange = (event: React.ChangeEvent<unknown>) => {
    // console.log((event.target as HTMLInputElement).value);
    this.setState({personalDetails: {
      gender: (event.target as HTMLInputElement).value} as ComponentState
    })
  }

  render() {
    const { values } = this.props;

    return (             
      <React.Fragment>
        <TextField 
            label = "Postal Code"
            name = "postalCode"
            margin = "normal"
            onChange= {this.handleTextChange('postalCode')}
            defaultValue = {this.props.values.postalCode}
        />
        <br/>
        <TextField 
            label = "Phone Number"
            name = "phoneNumber"
            margin = "normal"
            onChange= {this.handleTextChange('phoneNumber')}
            defaultValue = {this.props.values.phoneNumber}
        />
        <br/>
        <RadioGroup
            name="gender"
            defaultValue= {this.props.values.gender}
            onChange={this.handleRadioGroupChange}>
            <label>
                <Radio value="female" />Female
                </label>
                <label>
                <Radio value="male" />Male
                </label>
                <label>
                <Radio value="other" />Other
            </label>
        </RadioGroup>
        <br/>
        <Button 
            variant="contained"
            color="primary"
            onClick = {this.continue}
        >Continue
        </Button>
        <Button 
            variant="contained"
            color="default"
            onClick = {this.back}
        >back
        </Button>
      </React.Fragment>
    );
  }
}