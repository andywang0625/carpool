import React from 'react';
import {
    Typography,
    Container,
    InputLabel,
    FormControl,
    Input,
    Button,
    createStyles,
    Grid,
    CssBaseline,
    Avatar,
    Theme,
    withStyles
} from '@material-ui/core';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import { compose } from 'recompose';
import { withFormik,Form, FormikProps } from 'formik';
import { withNavigator, WithNavigatorChildProps } from '../../components/shared/Navigator';
import * as Yup from 'yup';
import { WithStyles } from '@material-ui/styles';

type StyleKeys = 'root' 
  | 'menuButton' 
  | 'title' 
  | 'button' 
  | 'paper' 
  | 'form' 
  | 'avatar';


interface Reset_PwdInput{
    email: string;
}

export interface Reset_PwdProps { }

export interface Reset_PwdBaseProps extends WithStyles<StyleKeys>, 
    FormikProps<Reset_PwdInput>,
    WithNavigatorChildProps{ }


class Reset_PwdBase extends React.PureComponent<
Reset_PwdBaseProps & Reset_PwdProps
> {
    // continue = ( e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
    //     const {history} = this.props;
    //     e.preventDefault();
    //     history.push('/confirm');
    // };

    renderResetPwd= ()=> {
        const { classes, errors, values, touched, handleChange, handleBlur, isValid} = this.props;
        return (              

                            <Form className={classes.form} >
                                <Grid container spacing={2} >
                                <Grid item xs={12} sm={12}>
                                <FormControl fullWidth={true} required>
                                    <InputLabel>Email</InputLabel>
                                        <Input
                                            name = "email"
                                            onChange= {handleChange}
                                            onBlur = {handleBlur}
                                            value = {values.email}
                                            error={touched.email ? (errors.email ? true : false) : undefined}
                                            autoFocus
                                        />
                                </FormControl>
                                </Grid>  
                                
                                <Button 
                                    variant="contained"
                                    color="primary"
                                    type="submit"
                                    disabled = {!isValid}
                                    className = {classes.button}
                                    fullWidth
                                >Submit
                                </Button>
                                </Grid>
                            </Form>

        );
    }
        
    render = () =>{
        const {classes} = this.props;
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
                        {this.renderResetPwd()}
                </div>
            </Container>
        );
    }
}

const Reset_PwdSchema = Yup.object().shape({
    email: Yup.string().email('Invalid email').required('Required')
});

const Reset_Pwd = compose<Reset_PwdBaseProps, Reset_PwdProps>(
    withStyles<StyleKeys, {}>((theme: Theme) => 
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
            backgroundColor: theme.palette.secondary.main
                }
            })  
    ),

    withFormik<Reset_PwdProps, Reset_PwdInput>({
        mapPropsToValues: (props) => {
        const initialValues: Reset_PwdInput = {
            email: '',
        };
        return initialValues;
    },
        validationSchema: Reset_PwdSchema,
        handleSubmit: (values, {setSubmitting })=>{


        }
    }),
    withNavigator
)(Reset_PwdBase);

export default Reset_Pwd