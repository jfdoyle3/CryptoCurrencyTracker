import React, { Component } from "react";
import "../css/currency.css";

class CurrencyInfoComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rank: "1",
      price: "9564.85130437",
      price_date: "2020-06-01T00:00:00Z",
      price_timestamp: "2020-06-01T14:39:00Z",
      circulating_supply: "18391300",
      max_supply: "21000000",
    };
  }
  render() {
    return <div className="container"></div>;
  }
}
export default CurrencyInfoComponent;
