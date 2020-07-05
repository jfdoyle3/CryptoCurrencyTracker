import React, { Component } from "react";
import { Link } from "react-router-dom";
import AuthenticationService from "../Auth/AuthenticationService.js";
import "../Styling/css/Header.css";

class HeaderComponent extends Component {
  render() {
    const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
    //console.log(isUserLoggedIn);

    return (
      <header>
        <nav>
          <div className="nav-wrapper">
          <a href="https://github.com/jfdoyle3/CryptocurrencyTracker" className="brand-logo">Logo</a>
            <ul id="nav-mobile" className="right hide-on-med-and-down">
              {isUserLoggedIn && (
                <li>
                  <Link className="nav-link" to="/welcome/user">
                    Home
                  </Link>
                </li>
              )}
              {isUserLoggedIn && (
                <li>
                  <Link className="nav-link" to="/cryptocurrenices">
                    Currencies
                  </Link>
                </li>
              )}
            </ul>
            {/* className="navbar-nav navbar-collapse justify-content-end" */}
            <ul >
              {!isUserLoggedIn && (
                <li>
                  <Link to="/login">Login</Link>
                </li>
              )}
              {isUserLoggedIn && (
                <li>
                  <Link to="/logout" onClick={AuthenticationService.logout}>
                    Logout
                  </Link>
                </li>
              )}
            </ul>
          </div>
        </nav>
      </header>
    );
  }
}

export default HeaderComponent;
