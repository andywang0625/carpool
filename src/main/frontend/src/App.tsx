import * as React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import { compose } from 'recompose';
import { Theme, createStyles, withStyles, WithStyles, Typography, CssBaseline, Container, makeStyles } from '@material-ui/core';

import SignUp from './sign-up';
import SignIn from './sign-in';
import Welcome from './welcome';
import CustomizedMenus from './menu';

export class App extends React.Component<{}> {

  render = () => {

    return (
      <Router>
        <div>
          <nav>
            <CustomizedMenus />
          </nav>

          <Route path="/" exact component={Welcome} />
          <Route path="/signup" component={SignUp} />
          <Route path="/signin" component={SignIn} />
        </div>
      </Router>
    );
  }

}
  withStyles(
    (theme: Theme) => createStyles<StyleKeys, AppProps>({
      root: {
        color: theme.palette.primary.main,
        fontSize: theme.typography.h1.fontSize,
      },
    }),
  ),
)(AppBase);
