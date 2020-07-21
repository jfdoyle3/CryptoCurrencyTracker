import axios from "axios";
import { API_URL } from "../../Constants.js";

class cryptocurrenciesDataService {
//   retrieve(name) {
//     //console.log('executed service')
//     return axios.get(`${API_URL}/users/{username}/cryptocurrencies/topfive`);
//   }


  // deletecryptocurrencies(name, id) {
  //   //console.log('executed service')
  //   return axios.delete(`${API_URL}/users/${name}/cryptocurrencies/${id}`);
  // }

  // updatecryptocurrencies(name, id, cryptocurrencies) {
  //   //console.log('executed service')
  //   return axios.put(`${API_URL}/users/${name}/cryptocurrencies/${id}`, cryptocurrencies);
  // }

  // createcryptocurrencies(name, cryptocurrencies) {
  //   //console.log('executed service')
  //   return axios.post(`${API_URL}/users/${name}/cryptocurrencies/`, cryptocurrencies);
  // }
}

export default new cryptocurrenciesDataService();
