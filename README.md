# 🧩 Kanban Board API

## 📌 About the Project

Kanban Board API is a backend application built with Java and Spring Boot that allows users to manage tasks using a Kanban-style board.

This project was designed to simulate a real-world task management system, applying best practices in software architecture, clean code, and RESTful API design.

---

## 🚀 Features

* Create and manage boards
* Create columns within boards
* Create and manage task cards
* Move cards between columns
* Block and unblock cards
* Enforce business rules (e.g., blocked cards cannot be moved)

---

## 🛠️ Technologies Used

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database
* Gradle
* Lombok

---

## 📂 Project Structure

```
src/main/java/com/cesargomide/kanbanboard

├── controller   # REST controllers
├── service      # Business rules
├── repository   # Data access layer
├── model        # Entities
├── dto          # Data Transfer Objects
└── exception    # Custom exceptions
```

---

## ▶️ How to Run

### Prerequisites

* Java 17+
* Gradle

### Steps

```bash
git clone https://github.com/your-username/kanban-board-api.git
cd kanban-board-api
./gradlew bootRun
```

The application will start at:

```
http://localhost:8080
```

---

## 🧪 API Testing

You can test the API using:

* Postman
* Insomnia

Example request:

```json
POST /cards

{
  "title": "Study Java",
  "description": "Build a Kanban project"
}
```

---

## 🔮 Future Improvements

* Add authentication and authorization (Spring Security)
* Integrate with PostgreSQL
* Add Docker support
* Implement unit and integration tests
* Deploy to cloud (AWS, Azure, or Railway)

---

## 📦 Version

v1.0.0 - Initial project setup

---

## 👨‍💻 Author

Developed by Cesar Gomide

---

## ⭐ Contributing

Contributions are welcome! Feel free to fork this repository and submit pull requests.

---

## 📄 License

This project is licensed under the MIT License.
