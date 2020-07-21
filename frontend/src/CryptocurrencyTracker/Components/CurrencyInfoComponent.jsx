import React, { Component } from "react";
import "../Styling/css/Currency.css";
import CurrencyInfoDataService from "../API/CurrencyInfoDataService.js";
import AuthenticationService from "../Auth/AuthenticationService.js";

class CurrencyInfoComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      symbol:"",
      price: "",
      price_date: "",
      price_timestamp: "",
      circulating_supply: "",
      max_supply: "",
    };
  }

  componentDidMount() {
    if (this.state.id === -1) {
      return;
    }

    let username = AuthenticationService.getLoggedInUserName();
    CurrencyInfoDataService.retrieveCurrencyInfo(username, this.state.symbol).then(
      (response) =>
        console.log(response)
        // this.setState({
        //   name: response.data.name,
        //   symbol: response.data.symbol,
        //   logo_url: response.data.logoUrl,
        //   ranking: response.data.ranking,
        // })
    );
  }
  render() {
    return (
      <div id="currencyInfo" classname="container">
        <p>Price: {this.state.price}</p>
        <p>Price Date: {this.state.price_date}</p>
            <p>Price Time Stamp: {this.state.price_timestamp}</p>
            <p>Circulating Supply: {this.state.circulating_supply}</p>
            <p>Max Supply: {this.state.max_supply}</p>
      </div>
    );
  }
}
export default CurrencyInfoComponent;

// rank: "1",
// price: "9564.85130437",
// price_date: "2020-06-01T00:00:00Z",
// price_timestamp: "2020-06-01T14:39:00Z",
// circulating_supply: "18391300",
// max_supply: "21000000",