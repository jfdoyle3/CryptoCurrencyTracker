import React, { Component } from "react";

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
    return (
      <div className="col s4">
        <p>Price: {this.state.price}</p>
        <p>Price Date: {this.state.price_date}</p>
        <div className="col s4">
          <span>
            <p>Price Time Stamp: {this.state.price_timestamp}</p>
            <p>Circulating Supply: {this.state.circulating_supply}</p>
            <p>Max Supply: {this.state.max_supply}</p>
          </span>
        </div>
      </div>
    );
  }
}
export default CurrencyInfoComponent;
