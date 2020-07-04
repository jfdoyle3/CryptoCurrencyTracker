import React, { Component } from "react";
// import LoginComponent from "./Components/LoginComponent.jsx";
// import SideNavComponent from "./Components/SideNavComponent.jsx";
import HeaderComponent from "./Components/HeaderComponent";
import CurrencyHeaderComponent from "./Components/CurrencyHeaderComponent.jsx";
import FooterComponent from "./Components/FooterComponent.jsx";
import "./App.css";
import "./materialize.css";

class App extends Component {
  render() {
    return (
      <div className="App">
        {/* <LoginComponent /> */}
        <HeaderComponent/>
        <CurrencyHeaderComponent />
        <FooterComponent />
      </div>
    );
  }
}

export default App;
