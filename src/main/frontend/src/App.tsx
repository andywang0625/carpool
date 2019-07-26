import * as React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { AppRoutes } from './AppRoutes';
import UserForm from './components/registration/UserForm';

export class App extends React.Component<{}> {
  render = () => {
    return (
      <BrowserRouter>
        <UserForm />
      </BrowserRouter>
    );
  }

}
