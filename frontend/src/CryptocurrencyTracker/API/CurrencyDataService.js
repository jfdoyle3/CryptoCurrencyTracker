import axios from "axios";

class cryptocurrenciesDataService {
  retrieveTopTen(name) {
    //console.log('executed service')
    return axios.get(
      `http://localhost:8080/users/{username}/cryptocurrencies/topTen`
    );
  }

  retrieveCryptocurrency(name, id) {
    console.log(`trying to get id: ${id}`);
    return axios.get(
      `http://localhost:8080/users/${name}/cryptocurrencies/id/${id}`
    );
  }

  // deletecryptocurrencies(name, id) {
  //   //console.log('executed service')
  //   return axios.delete(`http://localhost:8080/users/${name}/cryptocurrencies/${id}`);
  // }

  // updatecryptocurrencies(name, id, cryptocurrencies) {
  //   //console.log('executed service')
  //   return axios.put(`http://localhost:8080/users/${name}/cryptocurrencies/${id}`, cryptocurrencies);
  // }

  // createcryptocurrencies(name, cryptocurrencies) {
  //   //console.log('executed service')
  //   return axios.post(`http://localhost:8080/users/${name}/cryptocurrencies/`, cryptocurrencies);
  // }
}

export default new cryptocurrenciesDataService();
