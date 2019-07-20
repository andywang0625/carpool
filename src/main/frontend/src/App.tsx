import * as React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { AppRoutes } from './AppRoutes';

export class App extends React.Component<{}> {

  render = () => {

    return (
      <BrowserRouter>
        <AppRoutes />
      </BrowserRouter>
    );
  }

}
