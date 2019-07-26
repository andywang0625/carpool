import React from 'react';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import {createStyles } from '@material-ui/core/styles';
import { Theme, WithStyles, withStyles as styles, Grid, CssBaseline, Avatar, FormControlLabel, Checkbox} from '@material-ui/core';
import { ThemeProviderProps } from '@material-ui/styles/ThemeProvider';
import TextField from '@material-ui/core/TextField';
import Container from '@material-ui/core/Container';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
//@ts-ignore
import {Link, withRouter,RouteComponentProps} from 'react-router-dom';
//@ts-ignore
import { WithRouterProps } from 'react-router';
import * as yup from 'yup';
import {Form, Formik, Field} from 'formik';

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

const initialValues = {
    firstName: '',
    lastName: '',
    postalCode: '',
    phoneNumber: '',
    email: '',
    password:''
}

const validationSchema = yup.object().shape({
    firstName: yup.string()
    .required('Required'),
    lastName: yup.string()
    .required('Required')
    .min(3,"minimum 3"),
    email: yup.string()
    .email('Invalid email')
    .required('Required'),
    password: yup.string()
    .min(6,'Password must be at least 6 characters')
    .max(16,'too long')
    .required('Required'),
    postalCode: yup.string()
    .test('len', 'Must be exactly 6 characters', val => val.length === 6)
    .required('Required'),
    phoneNumber: yup.number()
    .required('Required')
    .min(10, 'Please enter an valid phone number')
})


export interface SignUpProps {
    handleChange: (input: React.ChangeEvent<HTMLInputElement>) => void 
    // values: any; 
}
export interface SignUpBaseProps extends WithStyles<StyleKeys>, ThemeProviderProps<Theme> , 
RouteComponentProps<SignUpRouteProps> {
    handleChange: (input: React.ChangeEvent<HTMLInputElement>) => void
    //values: any;
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
        const { classes } = this.props;
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
                            <Formik
                                initialValues = {initialValues}
                                validationSchema={validationSchema}
                                onSubmit = {values=>{console.log(values)}}
                            >
                            {({errors, values: {firstName, lastName, password, email, postalCode, phoneNumber}, 
                            touched, handleChange, isValid})=>(
                            <Form className={classes.form} >
                                <Grid container spacing={2} >
                                <Grid item xs={12} sm={6}>

                                <TextField 
                                    label = "First Name"
                                    name = "firstName"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    value = {firstName}
                                    variant ="outlined"
                                    //helperText={errors.firstName}
                                    error={touched.firstName && Boolean(errors.firstName)}
                                    required
                                    fullWidth
                                    autoFocus
                                />
                                {errors.firstName}
                                </Grid>  
                                <Grid item xs={12} sm={6}>
                                <TextField 
                                    label = "Last Name"
                                    name = "lastName"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    value = {lastName}
                                    variant ="outlined"
                                    //helperText={touched.lastName ? errors.lastName : null}
                                    error={touched.lastName && Boolean(errors.lastName)}
                                    required
                                    fullWidth
                                    autoFocus/>
                                 {errors.lastName}
                                </Grid>  
                                <Grid item xs={12} sm={6}>

                                <TextField 
                                    label = "Phone Number"
                                    name = "phoneNumber"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    value = {phoneNumber}
                                    variant="outlined"
                                    //helperText={touched.phoneNumber ? errors.phoneNumber : null}
                                    error={touched.phoneNumber && Boolean(errors.phoneNumber)}
                                    required
                                    fullWidth
                                    autoFocus/>
                                {errors.phoneNumber}

                                </Grid>
                                <Grid item xs={12} sm={6}>
                                <TextField 
                                    label = "Postal Code"
                                    name = "postalCode"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    value={postalCode}
                                    variant="outlined"
                                    //helperText={touched.postalCode ? errors.postalCode : null}
                                    error={touched.postalCode && Boolean(errors.postalCode)}
                                    required
                                    fullWidth
                                    autoFocus
                                /> 
                                {errors.postalCode}      
                                </Grid>
                                <Grid item xs={12} >
                                <TextField 
                                    label = "Email"
                                    name = "email"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    value={email}
                                    variant="outlined"
                                    //helperText={touched.email && errors.email ? errors.email : null}
                                    error={touched.email && Boolean(errors.email)}
                                    required
                                    fullWidth
                                    autoFocus
                                />
                                {errors.email}
                                </Grid>
                                <Grid item xs={12} >
                                <TextField 
                                    label = "Password"
                                    name = "password"
                                    margin = "normal"
                                    onChange= {handleChange}
                                    value = {password}
                                    variant="outlined"
                                    //helperText={touched.password ? errors.password : null}
                                    error={touched.password && Boolean(errors.password)}
                                    required
                                    fullWidth
                                    autoFocus
                                />
                                {errors.password}
                                </Grid>
                                <FormControlLabel
                                    control={<Checkbox value={"receiveEmail"} color="primary"/>}
                                    label="I want to receive marketing promotions and updates via email"/>
                                <Button 
                                    variant="contained"
                                    type="submit"
                                    color="primary"
                                    onClick = {this.continue}
                                    className = {classes.button}
                                    disabled = {!isValid}
                                    fullWidth
                                >Continue
                                </Button>
                                 
                                <Grid container justify="flex-end">
                                        <Link to="/signIn">
                                            Aready have an account? Sign in
                                        </Link>                    
                                </Grid>  
                                </Grid>
                            </Form>
                            )}
                            </Formik>
                        </div>
                    </Container>
        );
    }
}
 const SignUp = withStyles(withRouter(SignUpBase))
 export default SignUp;