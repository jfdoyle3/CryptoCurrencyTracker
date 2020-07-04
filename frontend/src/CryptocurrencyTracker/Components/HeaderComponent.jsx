import React, { Component } from "react";
import { Link } from "react-router-dom";
import AuthenticationService from "../Auth/AuthenticationService.js";


//import AuthenticationService from "./AuthenticationService.js";

class HeaderComponent extends Component {
  render() {
    const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
    //console.log(isUserLoggedIn);

    return (
      <header>
        <nav>
        <div class="nav-wrapper">
            <a
              href="https://github.com/jfdoyle3/JavaReactNoteBook"
              className="navbar-brand"
            >
              Java/React App
            </a>
          </div >
          <ul id="nav-mobile" class="right hide-on-med-and-down">
            {isUserLoggedIn && (
              <li>
                <Link className="nav-link" to="/welcome/user">
                  Home
                </Link>
              </li>
            )}
            {isUserLoggedIn && (
              <li>
                <Link className="nav-link" to="/todos">
                  Todos
                </Link>
              </li>
            )}
          </ul>
          <ul className="navbar-nav navbar-collapse justify-content-end">
            {!isUserLoggedIn && (
              <li>
                <Link  to="/login">
                  Login
                </Link>
              </li>
            )}
            {isUserLoggedIn && (
              <li>
                <Link
                 
                  to="/logout"
                  onClick={AuthenticationService.logout}
                >
                  Logout
                </Link>
              </li>
            )}
          </ul>
        </nav>
      </header>
    );
  }
}

export default HeaderComponent;


