import React, { Component } from "react";
import "../Styling/css/CurrencyDetail.css";
import CurrencyDataService from "../API/CurrencyDataService.js";
import AuthenticationService from "../Auth/AuthenticationService.js";

class CurrencyHeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "1",
      symbol: "BTC",
      name: "BTC",
      logo_url: "IMAGE",
      rank: "1",
    };
    // bind test button
    // this.props.match.params.id,
    // bind next currency function

    // bind back currency function
  }
  componentDidMount() {

      let username = AuthenticationService.getLoggedInUserName();
      CurrencyDataService.retrieveCryptocurrency(username, this.state.id).then(
        (response) =>
          //console.log(response)
          this.setState({
            name: response.data.name,
            symbol: response.data.symbol,
            logo_url: response.data.logoUrl,
            ranking: response.data.ranking,
          })
      );
  }

  render() {
    
    return (
      <div className="container">
        <div className="row">
          <div> 
            <img id="imgHeader" src={this.state.logo_url} alt="logo" />
          </div>
         <div>
            <h5><b>{this.state.name}</b></h5>
            <p><i>Symbol:</i> {this.state.symbol}</p>
            <p><i>Rank:</i> {this.state.ranking}</p>
          </div>
          <div className="col s12">

            {/* <CurrencyInfoComponent symbol={this.state.symbol}/> */}
        
          </div>
        </div>
        <div id="intervalTable">
        {/* <CurrencyIntervalComponent symbol={this.state.symbol}/> */}
        </div>
      </div>
    
     
    );
  }
}
export default CurrencyHeaderComponent;
