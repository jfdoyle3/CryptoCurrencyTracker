import React, { Component } from "react";
import "../Styling/css/Currency.css";
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
    if (this.state.id === -1) {
      return;
    }

<<<<<<< HEAD
    //   let username = AuthenticationService.getLoggedInUserName();
    //   CurrencyDataService.retrieveCryptocurrency(username, this.state.id).then(
    //     (response) =>
    //       //console.log(response)
    //       this.setState({
    //         name: response.data.name,
    //         symbol: response.data.symbol,
    //         logo_url: response.data.logoUrl,
    //         ranking: response.data.ranking,
    //       })
    //   );
  }

=======
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
 
>>>>>>> Working
  render() {
    
    return (
      <div className="container">
        <div className="row">
          <div> 
            <img id="imgHeader" src={this.state.logo_url} alt="logo" />
          </div>
         <div>
            <h6>{this.state.name}</h6>
            <p>Symbol: {this.state.symbol}</p>
            <p>Rank: {this.state.ranking}</p>
          </div>
<<<<<<< HEAD
=======
          <div className="col s12">

            <CurrencyInfoComponent symbol={this.state.symbol}/>
        
          </div>
>>>>>>> Working
        </div>
      </div>
    
     
    );
  }
}
export default CurrencyHeaderComponent;
