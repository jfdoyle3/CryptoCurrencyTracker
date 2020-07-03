import React, { Component } from "react";


//import AuthenticationService from "./AuthenticationService.js";

class HeaderComponent extends Component {
  render() {
   // const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
    //console.log(isUserLoggedIn);

    return (
      <header>
        <nav className="navbar navbar-expand-md navbar-dark bg-dark">
          <div>
          
          </div>
          <ul className="navbar-nav">
              <li>
              Home
              </li>
              <li>
               Menu Item 
              </li>
          </ul>
          <ul className="navbar-nav navbar-collapse justify-content-end">
              <li>
                Login
              </li>
            {/* {isUserLoggedIn && (
              <li>
                <Link
                  className="nav-link"
                  to="/logout"
                  onClick={AuthenticationService.logout}
                >
                  Logout
                </Link>
              </li>
            )} */}
          </ul>
        </nav>
      </header>
    );
  }
}

export default HeaderComponent;
