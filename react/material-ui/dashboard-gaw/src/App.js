import React from 'react';
import { createBrowserHistory } from "history";
import { Router, Route, Switch, Redirect } from "react-router-dom";

import AuthLayout from "layouts/Auth";
import AdminLayout from "layouts/Admin";
import LoginComponent from "views-gaw/Login/component/LoginComponent";
import AuthenticatedRoute from "views-gaw/Login/component/AuthenticatedRoute";

import "assets/scss/material-dashboard-pro-react.scss?v=1.8.0";

const hist = createBrowserHistory();

function App() {
  return (
    <div>      
      {console.log("App.js")}
      <Router history={hist}>
        <Switch>
          <AuthenticatedRoute path="/auth" component={AuthLayout} />
          <AuthenticatedRoute path="/admin" component={AdminLayout} />
          {/* <Route path="/admin" component={AdminLayout} /> */}
          <Route path="/login" component={LoginComponent} />
          {/* <Redirect from="/" to="/admin/dashboard" /> */}
          <Redirect from="/" to="/login" />
        </Switch>
      </Router>
    </div>
  );
}

export default App;
