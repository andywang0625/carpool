import * as React from 'react';
import * as ReactDOM from 'react-dom';
import { App } from './App';
import { MuiThemeProvider } from '@material-ui/core';
import { theme } from './config/theme';

ReactDOM.render(
  <MuiThemeProvider theme={theme}>
    <App />
  </MuiThemeProvider>,
  document.getElementById('root') as HTMLElement,
);
