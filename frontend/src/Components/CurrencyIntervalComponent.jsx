import React, { Component } from "react";
import "../css/currency.css";

class CurrencyHeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      volume: "27727114306.68",
      price_change: "103.17034381",
      price_change_pct: "0.0109",
      volume_change: "-3798607023.65",
      volume_change_pct: "-0.1205",
      market_cap_change: "1904769546.84",
      market_cap_change_pct: "0.0109",
    };
  }
  render() {
    return <div className="container"></div>;
  }
}
export default CurrencyHeaderComponent;
