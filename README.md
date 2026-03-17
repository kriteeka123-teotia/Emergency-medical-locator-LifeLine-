# 🚑 Emergency Medical Locator System
A full-stack web application designed to provide **real-time emergency medical assistance**, helping users find nearby **ambulances, blood banks, ICU beds, and oxygen supplies** instantly.


## 🌟 Features

* 🔐 User Authentication (Login / Register)
* 👤 Role-based access (User / Provider / Admin)
* 🚑 Emergency Request Creation
* 📍 Location-based service matching
* 🏥 Provider verification system (Admin)
* 📊 Request management system
* ⚡ Fast REST API integration
* 🎨 Modern responsive UI
* 

## 🛠️ Tech Stack

### Frontend
* HTML5
* CSS3
* JavaScript

### Backend
* Java (Spring Boot)

### Database
* MySQL


## 📂 Project Structure

```bash
emergency-locator
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── model/
│   ├── repository/
│
├── frontend/
│   ├── index.html
│   ├── login.html
│   ├── register.html
│   ├── dashboards/
│   ├── css/
│   ├── js/
│   └── assets/
```

## ⚙️ Setup Instructions

### 1. Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/emergency-locator.git
cd emergency-locator
```

### 2. Backend Setup

* Open project in IDE (IntelliJ / Eclipse)
* Configure database in `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/emergency_locator
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

Run Spring Boot Application.


### 3. Database Setup

Run SQL:

```sql
CREATE DATABASE emergency_locator;
```

Then run your tables script.

---

### 4. Frontend Setup

* Open frontend folder
* Run using Live Server OR open `index.html`

---

## 🔗 API Endpoints

### Authentication

* POST `/api/auth/register`
* POST `/api/auth/login`

### User

* POST `/api/request/create`

### Provider

* GET `/api/request/pending`
* POST `/api/request/accept/{id}`

### Admin

* GET `/api/admin/providers`
* PUT `/api/admin/verify/{id}`

---

## 🎯 Future Improvements
* 📍 Google Maps Integration
* 🔔 Real-time Notifications
* 📊 Admin Analytics Dashboard
* 📱 Mobile App Version

---

## 👨‍💻 Author
* Kriteeka Teotia

## 📜 License
This project is for educational purposes.
