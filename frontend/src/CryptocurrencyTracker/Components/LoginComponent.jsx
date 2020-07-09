import React, { Component } from "react";
import AuthenticationService from "../Auth/AuthenticationService.js";
import "../Styling/css/Login.css";

class LoginComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "user",
      password: "",
      hasLoginFailed: false,
      showSuccessMessage: false,
    };
    this.handleChange = this.handleChange.bind(this);
    this.loginClicked = this.loginClicked.bind(this);
  }
  
  handleChange(event) {
    //console.log(this.state);
    this.setState({
      [event.target.name]: event.target.value,
    });
  }
  loginClicked() {
	    AuthenticationService.basicAuthenticationService(
      this.state.username, this.state.password
    ).then (()=>{ AuthenticationService.registerSuccessfulLogin(
        this.state.username,
        this.state.password
      );
	this.props.history.push(`/welcome/${this.state.username}`);}).catch(()=>{      this.setState({ showSuccessMessage: false });
      this.setState({ hasLoginFailed: true });})
  }
  render() {
    return (
      <div className="container">
        <div className="header">
          <h2>
            <b>Cryptocurrency Tracker</b>
          </h2>
        </div>
        {this.state.hasLoginFailed && (
            <div className="alert alert-warning">Invalid Credentials</div>
          )}
          {this.state.showSuccessMessage && <div>Login Sucessful</div>}
        <div className="row">
          <div className="input-field col s10">
            <i className="material-icons prefix">personl</i>
            <input
             type="text"
             name="username"
             value={this.state.username}
              onChange={this.handleChange}
            />
          </div>
        </div>
        <div className="row">
          <div className="input-field col s10">
            <i className="material-icons prefix">https</i>
            <input
             name="password"
              type="password"
              value={this.state.password}
              onChange={this.handleChange}
            />
          </div>
        </div>
        <div className="row">
          <div className="col s7">
            <button
              className="btn btn-success"
              onClick={this.loginClicked}
            >
              Login
            </button>
          </div>
        </div>
      </div>
    );
  }
}

export default LoginComponent;
