import axios from "axios";

class HelloWorldService {
  executeHelloWorldService() {
    console.log("executed service");
    return axios.get("http://localhost:8080/hello-world");
  }

  executeHelloWorldBeanService() {
    //console.log('executed service')
    let userName = "user";
    let password = "password";
    let basicAuthHeader = "Basic " + window.btoa(userName + ":" + password);
    return (
      axios.get("http://localhost:8080/hello-world-bean"),
      {
        headers: {
          authorization: basicAuthHeader,
        },
      }
    );
  }
}

export default new HelloWorldService();
