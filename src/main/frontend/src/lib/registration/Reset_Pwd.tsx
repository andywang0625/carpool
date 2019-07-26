import React from 'react';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import {createStyles } from '@material-ui/core/styles';
import { Theme, WithStyles, withStyles as styles, Grid, CssBaseline, Avatar} from '@material-ui/core';
import { ThemeProviderProps } from '@material-ui/styles/ThemeProvider';
import TextField from '@material-ui/core/TextField';
import Container from '@material-ui/core/Container';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
//@ts-ignore
import {Link, Route, Router, withRouter,RouteComponentProps} from 'react-router-dom';
//@ts-ignore
import { WithRouterProps } from 'react-router';

type Reset_PwdRouteProps = {};

type StyleKeys = 'root' | 'menuButton' | 'title' | 'button' | 'paper' | 'form' | 'avatar';

const withStyles = styles<StyleKeys, {}>((theme: Theme) => 
    createStyles({
    root: {
        flexGrow: 1,
    },
    menuButton: {
        marginRight: theme.spacing(2),
    },
    title: {
        flexGrow: 1,
    },
    button: {
        margin: theme.spacing(1),
    },
    paper: {
        marginTop: theme.spacing(8),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
      },
    form: {
        width: '100%',
        marginTop: theme.spacing(3)
    },
    avatar: {
        backgroundColor: theme.palette.secondary.main,}
    })  
);

export interface Reset_PwdProps {
    handleChange: (input: React.ChangeEvent<HTMLInputElement>) => void 
    values: any; 
}
export interface Reset_PwdBaseProps extends WithStyles<StyleKeys>, ThemeProviderProps<Theme> , 
RouteComponentProps<Reset_PwdRouteProps> {
    handleChange: (input: React.ChangeEvent<HTMLInputElement>) => void
    values: any;
}
export interface Reset_PwdState {}

export class Reset_PwdBase extends React.PureComponent<
Reset_PwdBaseProps & Reset_PwdProps, 
Reset_PwdState
> {
    continue = ( e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
        const {history} = this.props;
        e.preventDefault();
        history.push('/confirm');
    };

    render() {
        //pull the value out
        const { classes, values, handleChange, theme} = this.props;
        return (              
                <Container component="main" maxWidth="xs" >
                    <CssBaseline />
                        <div className={classes.paper}>
                        <Avatar className={classes.avatar}>
                            <LockOutlinedIcon />
                        </Avatar>
                        <Typography component="h1" variant="h5">
                            Reset password?
                        </Typography>
                            <form className={classes.form} >
                                <Grid container spacing={2} >
                                <Grid item xs={12} sm={12}>
                                <TextField 
                                    label = "User Name/ Email"
                                    name = "account"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    value = {values.account}
                                    autoComplete="account"
                                    variant ="outlined"
                                    required
                                    fullWidth
                                    autoFocus
                                />
                                </Grid>  
                                <Button 
                                    variant="contained"
                                    color="primary"
                                    onClick = {this.continue}
                                    className = {classes.button}
                                    fullWidth
                                >Submit
                                </Button>
                                </Grid>
                            </form>
                        </div>
                    </Container>
                //</React.Fragment>
        );
    }
}
 const Reset_Pwd = withStyles(withRouter(Reset_PwdBase))
 export default Reset_Pwd;