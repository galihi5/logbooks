import React, { Component } from 'react'
import AuthenticationService from 'views-gaw/Login/service/AuthenticationService.js';

class LoginComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            userid: 'admin',
            password: '',
            hasLoginFailed: false,
            hasAuthenticated: false
        }

        this.handleChange = this.handleChange.bind(this);
        this.loginClicked = this.loginClicked.bind(this);
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]: event.target.value
            }
        )
    }

    loginClicked() {
        AuthenticationService
            .executeJwtAuthenticationService(this.state.userid, this.state.password)
            .then(res => {
                this.setState({ hasLoginFailed: false, hasAuthenticated: true });
                const jwtToken = res.headers.authorization;
                AuthenticationService.registerSuccessfulLoginForJwt(this.state.userid, jwtToken);
                this.props.history.push('/admin');
            }).catch(err => {
                console.log(err);
                this.setState({ hasLoginFailed: true, hasAuthenticated: false });
            });
    }

    logoutClicked() {
        AuthenticationService.logout();
    }

    render() {
        return (
            <div>
                <h1>Login</h1>
                <div className="container">
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                    User Name: <input type="text" name="userid" value={this.state.userid} onChange={this.handleChange} />
                    Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                    <button onClick={this.loginClicked}>Login</button>
                    <button onClick={this.logoutClicked}>Logout</button>
                </div>
            </div>
        )
    }
}

export default LoginComponent;