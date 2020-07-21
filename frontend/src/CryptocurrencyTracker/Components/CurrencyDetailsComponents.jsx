import React, { Component } from "react";
import CurrencyHeaderComponent from "./CurrencyHeaderComponent.jsx";
import CurrencyInfoComponent from "./CurrencyInfoComponent.jsx";
import CurrencyIntervalComponent from "./CurrencyIntervalComponent.jsx";
import "../Styling/css/Details.css";

class CurrencyDetailComponent extends Component {
  constructor(props){
  super(props);
  this.state={
    symbol: this.props.match.params.symbol,
    interval: this.props.match.params.interval
  }
}
  render() {
    return (
       <div id="details"> 
        <CurrencyHeaderComponent symbol={this.state.symbol} />
        <CurrencyInfoComponent symbol={this.state.symbol}/>
        {/* <CurrencyIntervalComponent symbol={this.state.symbol} interval={this.state.interval}/> */}
     </div>
    );
  }
}
export default CurrencyDetailComponent;
