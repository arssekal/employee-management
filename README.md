# 👩‍💼 Employee Management System

A full-stack web application to manage employee records using **Spring Boot** for the backend, **MySQL** for the database, and **React.js** for the frontend.

---

## 📌 Features

- Add a new employee
- Update employee details
- View list of all employees
- Delete employee record
- Responsive UI with validation

---

## 🛠️ Technologies Used

### 💻 Frontend
- React.js
- Axios
- React Router DOM
- HTML/CSS

### 🔧 Backend
- Spring Boot
- Spring Data JPA
- RESTful APIs

### 🗄️ Database
- MySQL

---

## 📂 Project Structure

```
employee-management/
├── backend/          # Spring Boot application
├── frontend/         # React app
└── README.md
```

---

## 🚀 How to Run the Project

### 1️⃣ Backend (Spring Boot)

1. Open the `/backend` folder in your IDE.
2. Create a MySQL database (e.g., `employeedb`).
3. Update `application.properties` with your DB credentials.
4. Run the Spring Boot app (e.g., `EmployeeManagementApplication.java`).

```bash
cd backend
./mvnw spring-boot:run
```

### 2️⃣ Frontend (React)

1. Open a new terminal in `/frontend`.
2. Install dependencies:

```bash
cd frontend
npm install
```

3. Start the React app:

```bash
npm start
```

The frontend will run at `http://localhost:3000` and the backend at `http://localhost:8080`.

---

## 🌐 API Endpoints

| Method | Endpoint             | Description             |
|--------|----------------------|-------------------------|
| GET    | `/api/employees`     | Get all employees       |
| POST   | `/api/employees/add-employee`     | Add a new employee      |
| GET    | `/api/employees/get-employee/{id}`| Get employee by ID      |
| PUT    | `/api/employees/update/{id}`| Update employee         |
| DELETE | `/api/employees/delete/{id}`| Delete employee         |

---

## 👨‍💻 Author

**Lhoussaine Arssekal**  
Étudiant ingénieur à l’ENSA d’Agadir  
📧 arssekallhoussaine@gmail.com

---

## 📃 License

This project is for educational purposes.
