import React, { Component } from 'react';
import { Route, Redirect } from 'react-router-dom';
import AuthenticationService from 'views-gaw/Login/service/AuthenticationService';

class AuthenticatedRoute extends Component {
    render() {
        console.log("AuthenticatedRoute ==> "+AuthenticationService.isUserLoggedIn());
        if (AuthenticationService.isUserLoggedIn()) {
            return <Route {...this.props} />
        } else {
            return <Redirect to="/login" />
        }

    }
}

export default AuthenticatedRoute;