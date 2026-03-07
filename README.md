# 📒 AddressBookApp

A Spring Boot based Java application developed using **Test-Driven Development (TDD)** to build a scalable Address Book system.

---

## 🧩 UC1 – Create Contact

Introduces the **Contact domain model** representing an entry in the Address Book.

### Fields
- First Name  
- Last Name  
- Address  
- City  
- State  
- Zip  
- Phone Number  
- Email  

### Implementation
- Created a **Contact model class** in the `model` package.
- Encapsulated all contact fields with constructors and getters.
- Added **JUnit test (`ContactTest`)** to verify correct creation of Contact objects.

---
### 📂 Project Structure
```
AddressBookApp
│
├── src
│   ├── main
│   │   └── java/com/addressbook
│   │       ├── model
│   │       │   └── Contact.java
│   │       └── AddressBookApplication.java
│   │
│   └── test
│       └── java/com/addressbook
│           └── ContactTest.java
│           └── AddressBookApplicationTests.java
├── pom.xml
└── README.md
```

## 🧰 Tech Stack
- Java 17+
- Spring Boot
- Maven
- JUnit 5
- Mockito

---

## ▶️ Run Project

```bash
./mvnw clean install
./mvnw test
./mvnw spring-boot:run

```

## ⚙️ Development Approach

This project follows the **Test-Driven Development (TDD)** methodology to ensure reliable and maintainable code.

The development process follows these steps:

- Write Tests First – Define the expected behaviour of the feature by writing unit tests before implementation.
- Implement the Code – Develop the minimum amount of code required to make the tests pass.
- Refactor Safely – Improve code structure and readability while ensuring all tests continue to pass.

This iterative approach helps maintain **code quality, reliability, and scalability** as new features are added to the Address Book system.
