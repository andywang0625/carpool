import React from 'react';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import Paper from '@material-ui/core/Paper';
import * as Yup from 'yup';
import { compose } from 'recompose';
import { 
  Theme,
  WithStyles,
  withStyles, 
  createStyles,
  Grid, 
  CssBaseline, 
  Avatar, 
  FormControlLabel, 
  Checkbox,
  FormControl,
  InputLabel,
  Input
} from '@material-ui/core';
import { FormikProps, withFormik, Form } from 'formik';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import { Link } from 'react-router-dom';
//@ts-ignore
import { withNavigator, WithNavigatorChildProps } from '/Users/shutingyang/HappyCoding/2019winter_AC_carpool_program/src/main/frontend/src/components/shared/Navigator.tsx';

type StyleKeys = 'root' 
| 'image' 
| 'paper' 
| 'avatar' 
| 'form' 
| 'submit';


interface SignInInput{ 
    userName: string;
    password: string;
}

export interface SignInProps { }

export interface SignInBaseProps extends WithStyles<StyleKeys>, 
  FormikProps<SignInInput>,
  WithNavigatorChildProps { }

class SignInBase extends React.PureComponent<SignInBaseProps & 
SignInProps> {

    renderSignInForm = () => {

        const { classes, values, handleChange, handleBlur, errors, touched, isValid } = this.props;
        return (         
            <Form className={classes.form} >
                <FormControl fullWidth={true} required>
                <InputLabel>User Name / Email</InputLabel>
                    <Input
                        name='userName'
                        value={values.userName}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        error={touched.userName ? (errors.userName ? true : false) : undefined}
                        autoFocus={true}
                    />
                <Typography>{errors.userName}</Typography>
                </FormControl>

                <FormControl fullWidth={true} required>
                <InputLabel>Password</InputLabel>
                    <Input
                        name='password'
                        value={values.password}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        error={touched.password ? (errors.password ? true : false) : undefined}
                        autoFocus={true}
                    />
                <Typography>{errors.password}</Typography>
                </FormControl>

                <FormControlLabel 
                    control = {<Checkbox value="remember" color="primary"/>}
                    label= "Remember me"/>
                <Button
                    type="submit"
                    fullWidth
                    variant="contained"
                    color="primary"
                    disabled={!isValid}
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
                </Form>                  
        );
    }

    render = () => {
        const { classes } = this.props;
        return (
            <Grid container component="main" className={classes.root}>
                <CssBaseline />
                <Grid item xs={false} sm={4} md={7} className={classes.image} />
                <Grid item xs={12} sm={8} md={5} component={Paper}>
                {/* <Paper elevation={3} square> */}
                    <div className={classes.paper}>
                        <Avatar className={classes.avatar}>
                            <LockOutlinedIcon />
                        </Avatar>
                        <Typography component="h1" variant="h5">
                            Sign in
                        </Typography>
                        {this.renderSignInForm()}
                    </div>
                    {/* </Paper> */}
                </Grid> 
            </Grid>  
        );
    }
}

const SignInSchema = Yup.object().shape({
    password: Yup.string()
      .min(6, 'Password must be at least 6 characters')
      .max(16, 'too long')
      .required('Required'),
    userName: Yup.string().required(),
  });

const SignIn = compose<SignInBaseProps, SignInProps>(
    withStyles<StyleKeys, {}>((theme: Theme) =>
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
                margin: theme.spacing(40, 4),
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
                margin: theme.spacing(5, 0, 2),
            },
            })  
    ),
withFormik<SignInProps, SignInInput>({
    mapPropsToValues: (props) => {
      const initialValues: SignInInput = {
        userName: '',
        password: '',
      };
      return initialValues;
    },
    validationSchema: SignInSchema,
    handleSubmit: (values, { setSubmitting }) => {
      // To-do, since we don't implement GraphQL service, for handling submittion, we could use
      // aoxis to send http POST request to backend APIs directly
      // once the backend API returns the success result, we can redirect the current page to login page or homepage
    }
  }),
  withNavigator
)(SignInBase);

export default SignIn
