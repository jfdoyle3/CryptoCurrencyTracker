import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import AuthenticatedRoute from "../Auth/AuthenticatedRoute.jsx";
import LoginComponent from "./LoginComponent.jsx";
import HeaderComponent from "./HeaderComponent.jsx";
import CurrencyHeaderComponent from "./CurrencyHeaderComponent.jsx";
import FooterComponent from "./FooterComponent.jsx";
import LogoutComponent from "./LogoutComponent.jsx";
import ErrorComponent from "./ErrorComponent.jsx";
import AdminComponent from "./AdminComponent.jsx";
import CurrencyListComponent from "./CurrencyListComponent.jsx";
import CurrencyDetailsComponent from "./CurrencyDetailsComponents.jsx";

class CryptocurrencyTracker extends Component {
  render() {
    return (
      <div>
        <Router>
          <>
            <HeaderComponent />
            <Switch>
              <Route path="/" exact component={LoginComponent} />
              <Route path="/login" component={LoginComponent} />
              <AuthenticatedRoute
                path="/welcome/:name"
                component={AdminComponent}
              />
              <AuthenticatedRoute
                path="/list"
                component={CurrencyListComponent}
              />
              <AuthenticatedRoute
                path="/details"
                component={CurrencyDetailsComponent}
              />
              <AuthenticatedRoute
                path="/cryptocurrenices/id/:id"
                component={CurrencyHeaderComponent}
              />
              <AuthenticatedRoute path="/logout" component={LogoutComponent} />

              <Route component={ErrorComponent} />
            </Switch>
            <FooterComponent />
          </>
        </Router>
      </div>
    );
  }
}

export default CryptocurrencyTracker;
