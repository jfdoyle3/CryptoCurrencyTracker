import React, { Component } from "react";
import "../Styling/css/CurrencyDetail.css";
import CurrencyInfoDataService from "../API/CurrencyInfoDataService.js";
import AuthenticationService from "../Auth/AuthenticationService.js";

class CurrencyInfoComponent extends Component {
  constructor(props) {
        super(props);
    this.state = {
      symbol: props.symbol,
      price: "",
      priceDate: "",
      priceTimeStamp: "",
      high_timestamp: "",
      circulating_supply: "",
      max_supply: "",
      market_cap: ""
    };
  }

  componentDidMount() {
  // console.log("info-mounted");
  //  console.log("symbol: "+this.state.symbol);
    let username = AuthenticationService.getLoggedInUserName(); 
    CurrencyInfoDataService.retrieveInfo(username, this.state.symbol).then(
      (response) =>
       this.setState({
          price: response.data.price,
          priceDate: response.data.priceDate,
          priceTimeStamp: response.data.priceTimeStamp,
          high: response.data.high,
          high_timeStamp: response.data.highTimeStamp,
          circulating_supply: response.data.circulatingSupply,
          max_supply:  response.data.maxSupply,
          market_cap: response.data.marketCap
            
        })
    );
  }


  render() {
    return (
<<<<<<< HEAD
<<<<<<< HEAD

      <div>
        <p>Price: {this.state.price}</p>
        <p>Price Date: {this.state.price_date}</p>
         
            <p>Price Time Stamp: {this.state.price_timestamp}</p>
            <p>Circulating Supply: {this.state.circulating_supply}</p>
            <p>Max Supply: {this.state.max_supply}</p>

     </div>
    
=======
=======
      <>
>>>>>>> Working
      <div id="currencyInfo" classname="container">
        <p><i>High:</i> {this.state.high}</p>
        <p><i>High TimeStamp:</i> {this.state.high_timeStamp}</p>
        <p><i>Circulating Supply:</i> {this.state.circulating_supply}</p>
        <p><i>Max Supply:</i> {this.state.max_supply}</p>
        </div>
        <div id="price">
        <p><i>Price:</i> <b>{this.state.price}</b></p>
        <p><i>Price TimeStamp:</i> {this.state.priceTimeStamp}</p>
      </div>
<<<<<<< HEAD
>>>>>>> Working
=======
      </>
>>>>>>> Working
    );
  }
}
export default CurrencyInfoComponent;
