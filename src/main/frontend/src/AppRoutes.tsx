import * as React from 'react';
import { Route, RouteComponentProps, Switch, withRouter } from 'react-router';
import { compose } from 'recompose';
//@ts-ignore
import SignUpForm from '/Users/shutingyang/HappyCoding/2019winter_AC_carpool_program/src/main/frontend/src/components/signUpRouter/SignUpForm.tsx';
//@ts-ignore
import SignIn from '/Users/shutingyang/HappyCoding/2019winter_AC_carpool_program/src/main/frontend/src/lib/registration/SignIn.tsx';
//@ts-ignore
import Confirm from '/Users/shutingyang/HappyCoding/2019winter_AC_carpool_program/src/main/frontend/src/lib/registration/Confirm.tsx';
//@ts-ignore
import Reset_Pwd from '/Users/shutingyang/HappyCoding/2019winter_AC_carpool_program/src/main/frontend/src/lib/registration/Reset_Pwd.tsx';

interface AppRoutesProps { }

interface AppRoutesBaseProps extends RouteComponentProps { }

class AppRoutesBase extends React.PureComponent<AppRoutesBaseProps> {
  render = () => (
    <Switch>
      <Route
        path="/signup" 
        component={SignUpForm} 
        exact
      />
      <Route
        path="/login"
        component={SignIn} 
      />
      <Route
        path="/confirm" 
        component={Confirm} 
      />
      <Route
        path="/reset_pwd" 
        component={Reset_Pwd}
      />

    </Switch>
  )
}

export const AppRoutes = compose<AppRoutesBaseProps, AppRoutesProps>(
  withRouter)(AppRoutesBase);
