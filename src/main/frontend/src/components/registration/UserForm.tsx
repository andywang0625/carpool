import React ,{ComponentState} from 'react';
// @ts-ignore
import SignIn from '../../lib/registration/SignIn.tsx';
// @ts-ignore
import Confirm from '/Users/shutingyang/HappyCoding/2019winter_AC_carpool_program/src/main/frontend/src/lib/registration/Confirm.tsx';
// @ts-ignore
import { BrowserRouter, Route} from "react-router-dom";
// @ts-ignore
import Reset_Pwd from '../../lib/registration/Reset_Pwd.tsx';
// @ts-ignore
import { SignUpForm } from '../signUpRouter/SignUpForm.tsx';


export interface UserFormProps {}

export interface UserFormBaseProps {}

export interface UserFormState {
}

export class UserForm extends React.PureComponent<
    UserFormProps & UserFormBaseProps,
    UserFormState
> {

    render() {

            return(
                <BrowserRouter>
                        <Route path="/signUp" component={SignUpForm} />  

                        <Route path="/login"
                            component={SignIn} />

                        <Route path="/confirm" 
                            component={Confirm} />
                    
                        <Route path="/reset_pwd" 
                            component={Reset_Pwd} />
                </BrowserRouter>

                );    
    }
}

export default UserForm