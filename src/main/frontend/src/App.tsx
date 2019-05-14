import * as React from 'react';
import { compose } from 'recompose';
import { Theme, createStyles, withStyles, WithStyles, Typography } from '@material-ui/core';

export type StyleKeys = 'root';

export interface AppProps { }

export interface AppBaseProps extends WithStyles<StyleKeys> { }

class AppBase extends React.Component<AppBaseProps> {

  render = () => {

    const { classes } = this.props;

    return <Typography>Hello World</Typography>;
  }

}

export const App: React.ComponentType<AppProps> = compose<AppBaseProps, AppProps>(
  withStyles(
    (theme: Theme) => createStyles<StyleKeys>({
      root: {

      },
    }),
  ),
)
  (AppBase);
