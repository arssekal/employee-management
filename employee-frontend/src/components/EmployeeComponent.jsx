import React, { useEffect, useState } from 'react'
import "../styleComponents/employeeComponent.css"
import { addEmployee, getEmployee, updateEmployee } from '../services/EmployeeService';
import { useNavigate, useParams } from 'react-router-dom';

const EmployeeComponent = () => {
    
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    
    const navigator = useNavigate();
    const {id} = useParams()

    // these is juste to fill the update form with the data already in the form to update what we want
    useEffect(() => {
        if(id) {
            getEmployee(id).then((response) => {
                setFirstName(response.data.firstName)
                setLastName(response.data.lastName)
                setEmail(response.data.email)
            }).catch((error) => {
                console.log(error)
            })
        }
    }, [])

  function saveOrUpdateEmployee(e) {
    e.preventDefault();
    
    if(validateForm()) {
        const employee = {firstName, lastName, email}
        console.log(employee)
        if(id) {
            updateEmployee(id, employee).then((response) => {
                console.log(response.data);
                navigator("/employees")
            }).catch((error) => {
                console.error(error)
            })
        } else {
            addEmployee(employee).then((response) => {
                console.log(response.data);
                navigator("/employees")
            }).catch((error) => {
                console.error(error)
            })
        }
    } else {
        alert("all fields shoud be full")
    }
    
  }

  function validateForm() {
    let valid = true;


    if(!firstName.trim() || !lastName.trim() || !email.trim()) {
        valid = false;
    } 

    return valid;

  }

  function pageTitle() {
    if(id) {
        return <h2>update employee</h2>
    } 
    return <h2>Add Employee</h2>
  }

  return (
    <div className='employee'>
        {pageTitle()}
        <form>
            <label htmlFor="">First Name:
                <input 
                    type="text" 
                    onChange={(e) => setFirstName(e.target.value)} 
                    name='firstName' 
                    value={firstName} 
                    placeholder='enter first name'
                />
            </label>
            <label htmlFor="">Last Name:
                <input 
                    onChange={(e) => setLastName(e.target.value)} 
                    type="text" 
                    name='lastName' 
                    value={lastName} 
                    placeholder='enter last name'
                />
            </label>
            <label htmlFor="">Email:
                <input 
                    onChange={(e) => setEmail(e.target.value)} 
                    name='email' 
                    value={email} type="email" 
                    placeholder='enter your email'
                />
            </label>
            <button type='submit' onClick={saveOrUpdateEmployee}>submit</button>
        </form>
    </div>
  )
}

export default EmployeeComponent