import React from 'react';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import Paper from '@material-ui/core/Paper';
import { createStyles } from '@material-ui/core/styles';
import { Theme, WithStyles, withStyles as styles, Grid, CssBaseline, Avatar} from '@material-ui/core';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import { ThemeProviderProps } from '@material-ui/styles/ThemeProvider';
import TextField from '@material-ui/core/TextField';

type StyleKeys = 'root' |  'button' | 'image' | 'paper' | 'avatar' | 'form';

const withStyles = styles<StyleKeys, {}>((theme: Theme) => 
    createStyles({
    root: {
        heigh:'100vh',
    },

    button: {
        margin: theme.spacing(1),
    }, 
    image: {
        backgroundImage: "url(https://source.unsplash.com/random)",
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover',
        backgroundPosition: 'center'
    },
    paper: {
        margin: theme.spacing(8,4),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    avatar:{
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
    form:{
        width: '100%',
        marginTop: theme.spacing(1)
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
                    <CssBaseline/>
                    <Grid item xs={false} sm={4} md={7} className={classes.image}/>
                        <Grid item xs={12} sm={8} md={5} component={Paper} >
                            <div className={classes.paper}>
                                <Avatar className={classes.avatar}>
                                    <LockOutlinedIcon/>
                                </Avatar>
                                <Typography component="h1" variant="h5">
                                    Sign in
                                </Typography>
                            </div>
                            <form className={classes.form} noValidate>
                            <TextField 
                                label = "User Name"
                                name = "userName"
                                margin = "normal"
                                onChange= {handleChange}
                                defaultValue = {values.userName}
                                // helperText = {values.postalCodeError}
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
                                // helperText = {values.postalCodeError}
                                autoComplete="password"
                                variant="outlined"
                                required
                                fullWidth
                                autoFocus
                                />
                            <br/>
                            </form>
                    </Grid>
                </Grid>    
            //    <React.Fragment>
            //     <AppBar position="static" color="inherit" aria-label="Menu" />
            //         <Toolbar>
            //             <IconButton edge="start" className = {classes.menuButton} color="inherit" aria-label = "Menu">
            //                 <MenuIcon />
            //             </IconButton>
            //             <Typography variant = "h6" className = {classes.title} color="inherit">
            //                 Enter personal details
            //             </Typography>
            //             <Button color= "inherit" onClick={this.continue}>Login</Button>
            //         </Toolbar>
            //         <br/>
            //         <TextField 
            //             label = "Postal Code"
            //             required
            //             name = "postalCode"
            //             margin = "normal"
            //             onChange= {handleChange}
            //             defaultValue = {values.postalCode}
            //             className = {classes.textField}
            //             helperText = {values.postalCodeError}/>
            //         <br/>
            //         <TextField 
            //             label = "Phone Number"
            //             name = "phoneNumber"
            //             margin = "normal"
            //             onChange= {handleChange}
            //             defaultValue = {values.phoneNumber}
            //             className = {classes.textField}
            //             helperText = {values.phoneNumberError}/>
            //         <br/>
            //         <RadioGroup
            //             row 
            //             className= {values.textField}
            //             name="gender"
            //             onChange={handleRadioGroupChange}>
            //             <label>
            //                 <Radio value="female" />Female  
            //                 </label>
            //                 <label>
            //                 <Radio value="male" />Male
            //                 </label>
            //                 <label>
            //                 <Radio value="other" />Other
            //             </label>
            //         </RadioGroup>
            //         <br/>
            //         <Button 
            //             variant="contained"
            //             color="primary"
            //             onClick = {this.continue}
            //             className = {classes.button}
            //         >Continue
            //         </Button>
            //         <Button 
            //             variant="contained"
            //             color="default"
            //             onClick = {this.back}
            //             className = {classes.button}
            //         >back
            //         </Button>
            //     </React.Fragment>
        );
    }
}
 const SignIn = withStyles(SignInBase)
 export default SignIn;