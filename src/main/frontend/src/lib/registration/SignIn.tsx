import React from 'react';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import Paper from '@material-ui/core/Paper';
import { createStyles } from '@material-ui/core/styles';
import { Theme, WithStyles, withStyles as styles, Grid, CssBaseline, Avatar, FormControlLabel, Checkbox} from '@material-ui/core';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import { ThemeProviderProps } from '@material-ui/styles/ThemeProvider';
import TextField from '@material-ui/core/TextField';
import { Link } from 'react-router-dom';

type StyleKeys = 'root' |   'image' | 'paper' | 'avatar' | 'form' | 'submit';

const withStyles = styles<StyleKeys, {}>((theme: Theme) => 
    createStyles({
    root: {
        height: '100vh',
        },
        image: {
        backgroundImage: 'url(https://static.vecteezy.com/system/resources/previews/000/144/446/original/vector-carpool-infographic.png)',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        },
    paper: {
        margin: theme.spacing(8, 4),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
      },
      avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
      },
      form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(1),
      },
      submit: {
        margin: theme.spacing(3, 0, 2),
      },
    })  
);

export interface SignInProps {
    handleChange: (input: React.ChangeEvent<HTMLInputElement>) => void, 
    //handleRadioGroupChange: ((event: React.ChangeEvent<{}>, value: string) => void) | undefined,
    values: any; 
}

export interface SignInBaseProps extends WithStyles<StyleKeys>, ThemeProviderProps<Theme> {
    handleChange: (input: React.ChangeEvent<HTMLInputElement>) => void, 
    //handleRadioGroupChange: ((event: React.ChangeEvent<{}>, value: string) => void) | undefined,
    values: any;   
}

export interface SignInState {}

export class SignInBase extends React.PureComponent<SignInBaseProps & 
SignInProps, SignInState> {

    render() {
        //pull the value out
        const { classes, theme, values, handleChange} = this.props;

        return (         
            <Grid container component="main" className={classes.root}>
                <CssBaseline />
                <Grid item xs={false} sm={4} md={7} className={classes.image} />
                <Grid item xs={12} sm={8} md={5} component={Paper}>
                    {/* <Paper elevation={6} square> */}
                    <div className={classes.paper}>
                    <Avatar className={classes.avatar}>
                        <LockOutlinedIcon />
                    </Avatar>
                    <Typography component="h1" variant="h5">
                        Sign in
                    </Typography>
                    <form className={classes.form} noValidate>
                        <TextField 
                            label = "User Name"
                            name = "userName"
                            margin = "normal"
                            onChange= {handleChange}
                            defaultValue = {values.userName}
                            autoComplete="uname"
                            variant="outlined"
                            required
                            fullWidth
                            autoFocus
                            />
                        <TextField 
                            label = "Password"
                            name = "password"
                            margin = "normal"
                            onChange= {handleChange}
                            defaultValue = {values.password}
                            autoComplete="password"
                            variant="outlined"
                            required
                            fullWidth
                            autoFocus
                            />
                        <FormControlLabel 
                            control = {<Checkbox value="remember" color="primary"/>}
                            label= "Remember me"/>
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            color="primary"
                            className={classes.submit}>
                            Sign In
                        </Button>
                        <Grid container>
                            <Grid item xs>
                                <Link to="/reset_pwd" >
                                    Forgot password?
                                </Link>
                            </Grid>
                            <Grid item >
                                <Link to="/signUp">
                                    {"Do not have an account? Sign Up"}
                                </Link>
                            </Grid>
                        </Grid>
                        </form>                  
                        </div>
                        {/* </Paper> */}
                    </Grid>
                </Grid>    
        );
    }
}
 const SignIn = withStyles(SignInBase)
 export default SignIn;