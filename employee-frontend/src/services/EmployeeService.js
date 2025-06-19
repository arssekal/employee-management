import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/employees";

export const listEmployees = () => {
    return axios.get(REST_API_BASE_URL+"/get-all");
} 

export const addEmployee = (employee) => {
    return axios.post(REST_API_BASE_URL+"/add-employee", employee);
} 

export const getEmployee = (id) => {
    return axios.get(REST_API_BASE_URL + "/get-employee/"+ id);
} 
export const updateEmployee = (id, employee) => {
    return axios.put(REST_API_BASE_URL + "/update/"+ id, employee);
} 
export const deleteEmployee = (id) => {
    return axios.delete(REST_API_BASE_URL + "/delete/"+ id);
} 