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

## ⚙️ Implementation

- Created an **AddressBook model** that stores contacts using a `List<Contact>`.
- Implemented **AddressBookService** to manage Address Books using a `Map<String, AddressBook>`.
- Added logic to **automatically create an Address Book** if the specified one does not exist.
- Developed **AddressBookController** to expose the following REST endpoint:

```
POST /addressbooks/{name}/contacts
```

## 🧩 UC3 – Update Existing Contact

Adds the functionality to **update an existing contact** in the Address Book through a REST API.  
This feature allows modification of stored contact details while keeping the contact record intact in the Address Book.

### Purpose

- Enable users to update contact information such as **address, city, state, zip code, phone number, and email**.
- Provide a way to **identify a contact using the first name and last name** within a specific Address Book.

### Implementation

- Implemented an **`updateContact()` method** in `AddressBookService` to locate a contact using **firstName and lastName** and update the required details.
- Created a **REST endpoint** in `AddressBookController`:

## 🧩 UC4 – Remove Contact

Introduces the functionality to delete an existing contact from an Address Book using a REST API.  
This feature enables users to keep their address book organized by removing contacts that are no longer required.

### Purpose
- Allow users to delete a contact from an Address Book using the contact's **first name** and **last name**.
- Maintain accurate and up-to-date contact information within the system.

### Implementation
- Developed a **deleteContact()** method in `AddressBookService` that locates and removes a contact from the `List<Contact>` using the `removeIf()` method.
- Created a REST API endpoint in `AddressBookController`:

  **DELETE /addressbooks/{bookName}/contacts**

- The API accepts **firstName** and **lastName** as query parameters to identify the contact to be deleted.
- Added **unit tests** to verify successful deletion, handle scenarios where the contact is not found, and cases where the requested Address Book does not exist.

## 🧩 UC5 – Manage Multiple Contacts

Adds support for storing and handling multiple contacts within an Address Book using Java collections.  
This feature allows users to retrieve all contacts associated with a specific Address Book.

### Purpose
- Enable the Address Book to store **multiple contact records** instead of being limited to a single entry.
- Provide an API that can **fetch all contacts** from a chosen Address Book.

### Implementation
- Utilized a **List<Contact>** inside the `AddressBook` model to maintain multiple contact entries.
- Implemented a **getContacts()** method in `AddressBookService` to return the list of contacts belonging to a given Address Book.
- Created a REST endpoint in `AddressBookController`:

  **GET /addressbooks/{bookName}/contacts**

- Added **unit tests** to validate scenarios such as retrieving multiple contacts, handling empty contact lists, managing duplicate contacts, working with large datasets, and supporting multiple Address Books.
---

## 🧩 UC6 – Support Multiple Address Books

Introduces the ability for the application to manage several Address Books simultaneously.  
Each Address Book is assigned a unique name and functions independently from the others.

### Purpose
- Allow users to categorize contacts into different Address Books such as **personal**, **work**, or **family**.
- Ensure contacts are maintained separately within their respective Address Books.

### Implementation
- Modified the service layer to maintain Address Books using a **Map<String, AddressBook>** data structure.
- Added service methods to **create new Address Books** and **retrieve existing ones**.
- Implemented REST API endpoints in `AddressBookController`:

  **POST /addressbooks/{name}**  
  **GET /addressbooks**

- Included **unit tests** to verify creation of multiple Address Books, prevent duplicate Address Book names, and confirm that contacts remain properly isolated within their corresponding Address Books.



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
