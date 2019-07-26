import * as React from 'react';
import { Route, RouteComponentProps, Switch, withRouter } from 'react-router';
import { compose } from 'recompose';

interface AppRoutesProps { }

interface AppRoutesBaseProps extends RouteComponentProps { }

class AppRoutesBase extends React.PureComponent<AppRoutesBaseProps> {
  render = () => (
    <Switch>
      <Route
        path='/'
        //component={}
        exaxt
      />
      <Route
        path='/login'
        //component={}
      />
      <Route
        path='signup'
        //component={}
      />
    </Switch>
  )
}

export const AppRoutes = compose<AppRoutesBaseProps, AppRoutesProps>(
  withRouter)(AppRoutesBase);
