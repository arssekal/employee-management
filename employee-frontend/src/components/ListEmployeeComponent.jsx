import React, { useEffect, useState } from 'react'
import  "../styleComponents/ListEmployeeComponentStyle.css"

import { deleteEmployee, listEmployees } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {

  const navigator = useNavigate();

  const [employees, setEmployees] = useState([])

  useEffect(() => {
    getAllEmployees();
  }, [])

  function getAllEmployees() {
    listEmployees().then((response) => {
        console.log(response.data); 
        setEmployees(response.data);
    }).catch(error => {
        console.error(error)
    })
  }
  function addNewEmployee() {
    navigator('/add-employee');
  }
  function updateEmployee(id) {
    navigator(`/update-employee/${id}`)
  }
  function removeEmployee(id) {
    deleteEmployee(id).then(() => {
        getAllEmployees();
    }).catch((error) => {
        console.error(error);
    })
  }
  
  return (
    <div>
        <h2>list of employees</h2>
        <div className='add-btn'>
            <button onClick={addNewEmployee}>add employee</button>
        </div>
        <table>
            <thead>
                <tr>
                    <th>employee id</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee => 
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td className='updateAndDelete'>
                                <button className='update' onClick={() => updateEmployee(employee.id)}>update</button>
                                <button className='delete' onClick={() => removeEmployee(employee.id)}>delete</button>
                            </td>
                        </tr>
                    )
                }
                <tr></tr>
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent