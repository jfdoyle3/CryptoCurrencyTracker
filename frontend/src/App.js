import React, { Component } from "react";
// import LoginComponent from "./Components/LoginComponent.jsx";
// import SideNavComponent from "./Components/SideNavComponent.jsx";
import CurrencyHeaderComponent from "./Components/CurrencyHeaderComponent.jsx";
// import "./App.css";
import "./materialize.css";

class App extends Component {
  render() {
    return (
      <div className="App">
        {/* <LoginComponent /> */}

        <CurrencyHeaderComponent />
      </div>
    );
  }
}

export default App;
