import React, { Component } from "react";
import CurrencyHeaderComponent from "./CurrencyHeaderComponent.jsx";
import CurrencyInfoComponent from "./CurrencyInfoComponent.jsx";
import CurrencyIntervalComponent from "./CurrencyIntervalComponent.jsx";

class CurrencyDetailComponent extends Component {
  render() {
    return (
      <div>
        <CurrencyHeaderComponent />
        <CurrencyInfoComponent />
        <CurrencyIntervalComponent />
      </div>
    );
  }
}
export default CurrencyDetailComponent;
