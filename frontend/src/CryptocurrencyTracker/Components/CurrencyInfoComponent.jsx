import React, { Component } from "react";
import "../Styling/css/Currency.css";
import CurrencyInfoDataService from "../API/CurrencyInfoDataService.js";
import AuthenticationService from "../Auth/AuthenticationService.js";

class CurrencyInfoComponent extends Component {
  constructor(props) {
        super(props);
        console.log("info-constructor---> props: "+props.symbol);
    this.state = {
      symbol:"",
      price: "",
      price_date: "",
      high_timestamp: "",
      circulating_supply: "",
      max_supply: "",
      market_cap: ""
    };
  }

  componentDidMount() {
    console.log("info-mounted");
    console.log("symbol: "+this.state.symbol);
    let username = AuthenticationService.getLoggedInUserName(); 
    CurrencyInfoDataService.retrieveInfo(username, this.state.symbol).then(
      (response) =>
      //  this.setState({
      //     price: response.data.price,
      //     high: response.data.high,
      //     high_timeStamp: response.data.highTimeStamp,
      //     circulating_supply: response.data.circulatingSupply,
      //     max_supply:  response.data.maxSupply,
      //     market_cap: response.data.marketCap
            
      //   })
      console.log(response)
    );
  }


  render() {
    return (
      <div id="currencyInfo" classname="container">
        <p>Price: <b>{this.state.price}</b></p>
        <p>High: {this.state.high}</p>
        <p>High TimeStamp: {this.state.high_timeStamp}</p>
        <p>Circulating Supply: {this.state.circulating_supply}</p>
        <p>Max Supply: {this.state.max_supply}</p>
      </div>
    );
  }
}
export default CurrencyInfoComponent;
