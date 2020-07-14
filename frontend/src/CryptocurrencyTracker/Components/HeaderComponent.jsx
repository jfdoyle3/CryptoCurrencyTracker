import React, { Component } from "react";
import { Link } from "react-router-dom";
import AuthenticationService from "../Auth/AuthenticationService.js";
//import { Navbar, NavItem } from "react-materialize";
import "../Styling/css/Header.css";

//import "../Styling/css/Header.css";

class HeaderComponent extends Component {
  render() {
    const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
    //console.log(isUserLoggedIn);

    return (
      <div className="navbar-fixed">
        <nav>
          <div className="nav-wrapper">
            <a href="#!">Logo</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
              {/* {isUserLoggedIn && (
                <li>
                  <Link to="/welcome/user">Home</Link>
                </li>
              )}
              {isUserLoggedIn && (
                <li>
                  <Link to="/cryptocurrenices">Currencies</Link>
                </li>
              )} */}
            </ul>
            {/* className="navbar-nav navbar-collapse justify-content-end" */}
            <ul>
              {/* {!isUserLoggedIn && (
                <li>
                  <Link to="/login">Login</Link>
                </li>
              )} */}
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
      </div>
    );
  }
}

export default HeaderComponent;
