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
import {Link, Route, Router, Redirect, withRouter,RouteComponentProps} from 'react-router-dom';
//@ts-ignore
import { WithRouterProps } from 'react-router';

type SignUpRouteProps = {};

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

export interface SignUpProps {
    handleChange: (input: React.ChangeEvent<HTMLInputElement>) => void 
    values: any; 
}
export interface SignUpBaseProps extends WithStyles<StyleKeys>, ThemeProviderProps<Theme> , 
RouteComponentProps<SignUpRouteProps> {
    handleChange: (input: React.ChangeEvent<HTMLInputElement>) => void
    values: any;
}
export interface SignUpState {}

export class SignUpBase extends React.PureComponent<
SignUpBaseProps & SignUpProps, 
SignUpState
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
                            Sign up
                        </Typography>
                            <form className={classes.form} >
                                <Grid container spacing={2} >
                                <Grid item xs={12} sm={6}>
                                <TextField 
                                    label = "First Name"
                                    name = "firstName"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    value = {values.firstName}
                                    helperText = {values.firstNameError}
                                    autoComplete="fname"
                                    variant ="outlined"
                                    required
                                    fullWidth
                                    autoFocus
                                />
                                </Grid>  
                                <Grid item xs={12} sm={6}>
                                <TextField 
                                    label = "Last Name"
                                    name = "lastName"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    defaultValue = {values.lastName}
                                    helperText = {values.lastNameError}
                                    autoComplete="lname"
                                    variant ="outlined"
                                    required
                                    fullWidth
                                    autoFocus/>
                                </Grid>  
                                <Grid item xs={12} sm={6}>
                                <TextField 
                                    label = "Phone Number"
                                    name = "phoneNumber"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    defaultValue = {values.phoneNumber}
                                    helperText = {values.phoneNumberError}
                                    autoComplete="pn"
                                    variant="outlined"
                                    required
                                    fullWidth
                                    autoFocus/>
                                </Grid>
                                <Grid item xs={12} sm={6}>
                                <TextField 
                                    label = "Postal Code"
                                    name = "postalCode"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    defaultValue = {values.postalCode}
                                    helperText = {values.postalCodeError}
                                    autoComplete="pcode"
                                    variant="outlined"
                                    required
                                    fullWidth
                                    autoFocus/>       
                                </Grid>
                                <Grid item xs={12} >
                                <TextField 
                                    label = "Email"
                                    name = "email"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    defaultValue = {values.email}
                                    helperText = {values.emailError}
                                    autoComplete="email"
                                    variant="outlined"
                                    required
                                    fullWidth
                                    autoFocus
                                />
                                </Grid>
                                <Grid item xs={12} >
                                <TextField 
                                    label = "Password"
                                    name = "password"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    defaultValue = {values.password}
                                    helperText = {values.passwordError}
                                    autoComplete="pword"
                                    variant="outlined"
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
                                >Continue
                                </Button>
                                <Grid container justify="flex-end">
                                        <Link to="/signIn">
                                            Aready have an account? Sign in
                                        </Link>                    
                                </Grid>  
                                </Grid>
                            </form>
                        </div>
                    </Container>
                //</React.Fragment>
        );
    }
}
 const SignUp = withStyles(withRouter(SignUpBase))
 export default SignUp;