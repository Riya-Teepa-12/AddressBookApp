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


## 🧩 UC2 – Add Contact to Address Book

This use case introduces the functionality to add new contacts to an Address Book through a REST API. It also sets up the core service structure required to manage contacts across multiple Address Books.

---

## 🎯 Purpose

- Allow the application to store and organize contacts within an Address Book.
- Provide a backend API to accept contact information such as **first name, last name, address, city, state, zip code, phone number, and email**.

---

## ⚙️ Implementation

- Created an **AddressBook model** that stores contacts using a `List<Contact>`.
- Implemented **AddressBookService** to manage Address Books using a `Map<String, AddressBook>`.
- Added logic to **automatically create an Address Book** if the specified one does not exist.
- Developed **AddressBookController** to expose the following REST endpoint:

```
POST /addressbooks/{name}/contacts
```

### 📂 Project Structure

```
AddressBookApp
│
├── src
│   ├── main
│   │   ├── java/com/addressbookapp
│   │   │   ├── controller
│   │   │   │   └── AddressBookController.java
│   │   │   │
│   │   │   ├── model
│   │   │   │   ├── AddressBook.java
│   │   │   │   └── Contact.java
│   │   │   │
│   │   │   ├── service
│   │   │   │   └── AddressBookService.java
│   │   │   │
│   │   │   └── AddressBookApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│       └── java/com/addressbookapp
│           ├── AddressBookServiceTest.java
│           ├── AddressbookappApplicationTests.java
│           └── ContactTest.java
│── pom.xml
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
