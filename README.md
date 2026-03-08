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

## 🧩 UC7 – Prevent Duplicate Contacts

Enhances the Address Book system by ensuring that duplicate contacts cannot be added within the same Address Book.  
A contact is considered unique based on the combination of **first name** and **last name**.

### Purpose
- Maintain data integrity by preventing repeated contact entries.
- Ensure that the same person cannot be stored more than once in a single Address Book.

### Implementation
- Added validation logic in `AddressBookService` to verify whether a contact already exists before adding a new entry.
- Utilized **Java Streams** with the `anyMatch()` method to check if a contact with the same `firstName` and `lastName` is already present.
- If a duplicate contact is detected, the system throws an **exception** to prevent insertion.
- Implemented **unit tests** to validate duplicate detection, confirm successful addition of unique contacts, and allow identical contacts across different Address Books.

## 🧩 UC8 – Search Contacts by City or State

Adds functionality to locate contacts based on their **city** or **state** across all Address Books.  
This feature makes it easier to filter and retrieve contacts using location details.

### Purpose
- Help users quickly identify contacts belonging to a particular **city** or **state**.
- Enable searching across **all Address Books** available in the system.

### Implementation
- Developed search logic in `AddressBookService` using **Java Streams**.
- Aggregated contacts from every Address Book and applied filters based on the provided **city** or **state**.
- Implemented REST API endpoints in `AddressBookController`:

  **GET /addressbooks/search/city/{city}**  
  **GET /addressbooks/search/state/{state}**

- Added **unit tests** to verify correct search results, ensure **case-insensitive matching**, support multiple matching contacts, and handle cases where no contacts match the search criteria.

## 🧩 UC9 – Display Contacts by City or State

Adds functionality to display contacts grouped according to their **city** or **state** across all Address Books.  
This helps organize contact information based on location for better visibility and analysis.

### Purpose
- Enable users to view contacts categorized by their **city** or **state**.
- Provide a structured way to organize and analyze contacts based on location.

### Implementation
- Implemented grouping functionality in `AddressBookService` using **Java Streams** along with `Collectors.groupingBy()`.
- Contacts are organized into a **Map<String, List<Contact>>** structure where the key represents the city or state.
- Added REST API endpoints in `AddressBookController`:

  **GET /addressbooks/view/city**  
  **GET /addressbooks/view/state**

- Created **unit tests** to validate grouping logic, ensure correct handling of multiple Address Books, and test cases with empty contact collections.

## 🧩 UC10 – Count Contacts by City or State

Adds functionality to calculate the number of contacts grouped by their **city** or **state** across all Address Books.  
This feature helps provide insights into how contacts are distributed by location.

### Purpose
- Allow users to view the **total number of contacts** associated with each city or state.
- Offer summarized statistics of contacts across all Address Books.

### Implementation
- Implemented counting logic in `AddressBookService` using **Java Streams** with `Collectors.groupingBy()` and `Collectors.counting()`.
- Contacts are aggregated into a structure represented by:

  **Map<String, Long>**

- Added REST API endpoints in `AddressBookController`:

  **GET /addressbooks/count/city**  
  **GET /addressbooks/count/state**

- Included **unit tests** to verify counting across multiple Address Books, handle empty contact lists, and validate contacts belonging to different cities or states.

## 🧩 UC11 – Sort Contacts by Name

Adds the ability to arrange contacts alphabetically by their **first name** within an Address Book.  
This improves readability and makes it easier for users to browse contacts.

### Purpose
- Allow users to view contacts in **alphabetical order** for easier navigation.
- Provide a structured and consistent way to display contact lists.

### Implementation
- Implemented sorting logic in `AddressBookService` using **Java Streams** with `Comparator.comparing()` on the `firstName` field.
- Added a REST API endpoint in `AddressBookController`:

  **GET /addressbooks/{bookName}/sort/name**

- Overrode the `toString()` method in the `Contact` model to display contact details in a readable format.
- Added **unit tests** to verify sorting behavior, handle empty Address Books, and test scenarios with multiple contacts.

## 🧩 UC12 – Sort Contacts by City, State, or Zip

Enhances the sorting functionality by allowing contacts to be arranged based on **city**, **state**, or **zip code** within an Address Book.  
This provides more flexibility in organizing contacts using location-based details.

### Purpose
- Enable users to display contacts sorted by **city**, **state**, or **zip code**.
- Improve the organization and accessibility of contact information using geographical attributes.

### Implementation
- Implemented sorting logic in `AddressBookService` using **Java Streams** with `Comparator.comparing()` for the fields `city`, `state`, and `zip`.
- Added REST API endpoints in `AddressBookController`:

  **GET /addressbooks/{bookName}/sort/city**  
  **GET /addressbooks/{bookName}/sort/state**  
  **GET /addressbooks/{bookName}/sort/zip**

- Added **unit tests** to verify sorting behavior, including cases with empty Address Books and scenarios with a single contact.

## 🧩 UC13 – File IO Integration

Adds support for file persistence in the Address Book application using Java File IO.  
This feature allows contacts to be saved to a file and later retrieved from it.

### Purpose
- Enable the Address Book to store contact data permanently outside the application's runtime memory.
- Allow previously saved contacts to be loaded back into the system when needed.

### Implementation
- Developed a utility class `FileUtil` to handle file operations using `BufferedWriter` and `BufferedReader`.
- Implemented methods to write Address Book contacts to a file and read them back into memory.
- Added REST API endpoints in `AddressBookController`:

  **POST /addressbooks/{bookName}/save**  
  **GET /addressbooks/load**

- Included unit tests to verify file creation, reading contacts from files, handling empty files, and saving multiple contacts successfully.

## 🧩 UC14 – CSV File Integration

Adds support for storing and retrieving Address Book contacts using a structured CSV file format.  
This feature allows exporting contacts to CSV files and importing them back into the application.

### Purpose
- Enable contacts to be saved and loaded using a structured **CSV file format**.
- Provide a **portable and standardized format** for storing contact data.

### Implementation
- Developed a utility class `CSVUtil` to handle CSV operations using the **OpenCSV** library (`CSVReader` and `CSVWriter`).
- Implemented methods to write contacts from an Address Book to a CSV file and read contacts from a CSV file into memory.
- Added REST API endpoints in `AddressBookController`:

  **POST /addressbooks/{bookName}/save-csv**  
  **GET /addressbooks/load-csv**

- Included unit tests to verify CSV file creation, reading contacts from CSV files, handling multiple contacts, and processing empty CSV files.

## 🧩 UC15 – JSON File Integration

Adds support for storing and retrieving Address Book contacts using a structured JSON format.  
This feature enables exporting contacts to JSON files and importing them back into the application.

### Purpose
- Allow contacts to be saved and retrieved in a **structured JSON format**.
- Provide a **flexible and widely used format** for storing and exchanging contact data.

### Implementation
- Developed a utility class `JSONUtil` to manage JSON serialization and deserialization using the **GSON** library.
- Implemented methods to write contacts from an Address Book to a JSON file and read contacts from a JSON file into memory.
- Added REST API endpoints in `AddressBookController`:

  **POST /addressbooks/{bookName}/save-json**  
  **GET /addressbooks/load-json**

- Included unit tests to verify JSON file creation, reading contacts from JSON files, handling multiple contacts, and processing empty JSON file scenarios.

## 🧩 UC16 – Retrieve Contacts from Database & Storage Layer Refactor

Introduces database integration to retrieve contacts using **JDBC** and refactors the storage architecture to support multiple persistence formats through a **storage abstraction layer**.

### 🎯 Purpose

- Enable retrieval of contacts stored in a **relational database**.
- Decouple storage logic from business logic to allow support for **multiple storage formats** such as **File, CSV, and JSON**.

### ⚙️ Implementation

- Externalized database configuration in `application.properties`, allowing Spring Boot to automatically configure a **DataSource**.
- Implemented a **ContactRepository** to execute SQL queries and map database rows to `Contact` objects.
- Added a REST API endpoint in `AddressBookController`:

## 🧩 UC17 – Update Contact in Database

Introduces the ability to update a contact's city directly in the database using JDBC through the repository layer.

### 🎯 Purpose

* Enable modification of existing contact details stored in the database.
* Demonstrate database update operations using JDBC with Spring Boot DataSource.

### ⚙️ Implementation

* Added `updateContactCity()` method in **ContactRepository** to execute an SQL `UPDATE` query.
* Exposed the update functionality through **AddressBookService**.
* Added a new REST API endpoint in **AddressBookController**:

```
PUT /addressbooks/db/update-city
```

### 📥 Request Parameters

| Parameter | Description        |
| --------- | ------------------ |
| firstName | Contact first name |
| lastName  | Contact last name  |
| city      | New city value     |

### 🧪 Testing

* Added a repository integration test to verify that the database update operation successfully modifies the contact record.

## 🧩 UC18 – Retrieve Contacts by Date Range

Introduces the ability to retrieve contacts from the database based on a specified date range.

### 🎯 Purpose

* Allow users to fetch contacts added within a specific time period.
* Demonstrate database querying using JDBC with date filtering.

### ⚙️ Implementation

* Added a `date_added` column in the **contacts** database table.
* Implemented `getContactsByDateRange()` method in **ContactRepository** to execute an SQL query using the `BETWEEN` clause.
* Exposed the functionality through **AddressBookService**.
* Added a REST API endpoint in **AddressBookController**:

```
GET /addressbooks/db/contacts-by-date
```

### 📥 Request Parameters

| Parameter | Description             |
| --------- | ----------------------- |
| startDate | Start date of the range |
| endDate   | End date of the range   |

### 📌 Example Request

```
GET /addressbooks/db/contacts-by-date?startDate=2026-03-01&endDate=2026-03-10
```

### 🧪 Testing

* Added a repository test to verify that contacts within the specified date range are successfully retrieved from the database.

## 🧩 UC19 – Add Contact to Database

Introduces the ability to insert new contacts directly into the database using JDBC through the repository layer.

### 🎯 Purpose

* Enable storing contact information permanently in the relational database.
* Demonstrate database **INSERT operations** using JDBC with Spring Boot DataSource.

### ⚙️ Implementation

* Implemented `addContact()` method in **ContactRepository** using a prepared SQL `INSERT` statement.
* Automatically stores the current date using `CURDATE()` for the `date_added` column.
* Exposed the functionality through **AddressBookService**.
* Added a REST API endpoint in **AddressBookController**:

```
POST /addressbooks/db/add-contact
```

### 📥 Request Body

Example JSON request:

```json
{
  "firstName": "Aman",
  "lastName": "Sharma",
  "city": "Delhi",
  "state": "DL",
  "zip": "110001",
  "phoneNumber": "8888888888",
  "email": "aman@gmail.com"
}
```

### 🧪 Testing

* Added repository integration tests to verify successful insertion of a new contact into the database.


## 🧩 UC20 – Add Contact to Database Using JDBC

Enhances the AddressBook system by enabling the insertion of new contact records directly into the database using JDBC.

### 🎯 Purpose
- Persist newly created contacts in the database.
- Ensure reliable and secure database operations.

### ⚙️ Implementation
- Extended **ContactRepository** with an SQL `INSERT` query using **JDBC PreparedStatement**.
- Implemented transaction handling using:
  - `setAutoCommit(false)`
  - `commit()`
  - `rollback()`
- Added a service method in **AddressBookService** to manage database insertion through the repository layer.
- Created a REST endpoint in **AddressBookController**:


## 🧩 UC21 – Add Multiple Contacts to Database Using Multithreading

Enhances the AddressBook system to support inserting multiple contacts into the database concurrently using **multithreading**.

### 🎯 Purpose
- Improve performance when inserting multiple contacts by executing database operations concurrently.
- Demonstrate the use of **Java multithreading** for handling parallel database operations.

### ⚙️ Implementation
- Created a **threads package** and implemented an `AddContactTask` class that implements `Runnable` to handle individual contact insertion tasks.
- Reused the existing `addContact()` method in `ContactRepository` to perform **JDBC database insertion**.
- Implemented a service method in `AddressBookService` to create and manage multiple threads, where each thread inserts one contact into the database.
- Added a REST endpoint in `AddressBookController`:

## 🧩 UC22 – Read Contacts from JSON Server using REST Assured

Enhances the AddressBook system to retrieve contact records from an external **JSON Server** using REST API calls executed through automated tests.

### 🎯 Purpose
- Enable the application to integrate with an external REST service that provides contact data.
- Demonstrate **REST API testing using the REST Assured library**.

### ⚙️ Implementation
- Installed and configured **json-server** to simulate a REST API using a `db.json` file containing sample contact records.
- Started the JSON server on **port 3000**, exposing REST endpoints such as:

## 🧩 UC23 – Add Contacts to JSON Server using REST Assured

Extends the AddressBook system to allow **adding new contact records to an external JSON server** through REST API calls executed from automated tests.

### Purpose
- Enable the system to **create new contact entries** in a REST-based data source.
- Demonstrate how **REST Assured** can be used to perform **POST requests and validate API responses**.

### Implementation
- Configured a **json-server mock REST API** running on **port 3000** using a `db.json` file containing contact records.
- Implemented a **REST Assured automated test** that sends a POST request to the endpoint:

- Sent contact details in **JSON format** using `contentType("application/json")` along with the request body.
- Verified the server response by checking the **HTTP status code `201 Created`** and validating the returned JSON data.

### Outcome
The AddressBook system can now **add new contacts to an external JSON server through REST API calls**, enabling automated verification of the contact creation functionality.

## 🧩 UC24 – Update Contact in JSON Server using REST Assured

Extends the AddressBook system to support **updating existing contact records in an external JSON server** using REST API calls executed through automated tests.

### Purpose
- Enable the system to **modify existing contact information** stored in a REST-based data source.
- Demonstrate the use of **REST Assured** to perform **HTTP PUT requests and validate API responses**.

### Implementation
- Configured a **json-server mock REST API** running on **port 3000** with a `db.json` file containing contact records.
- Implemented a **REST Assured automated test** that sends a PUT request to the endpoint:

- Sent the **updated contact details in JSON format** using `contentType("application/json")` along with the request body.
- Verified the server response by checking the **HTTP status code `200 OK`** and validating the returned JSON response.

### Outcome
The AddressBook system can now **update existing contact records on an external JSON server through REST API calls**, enabling automated verification of contact update functionality.

## 🧩 UC25 – Delete Contact from JSON Server using REST Assured

Enhances the AddressBook system to support deleting contact records from an external **JSON Server** through REST API calls executed from automated tests.

### 🎯 Purpose
- Enable the system to remove contact records stored in a **REST-based data source**.
- Demonstrate the use of **REST Assured** to perform HTTP **DELETE** requests and validate responses.

### ⚙️ Implementation
- Used the **json-server mock REST API** running on **port 3000** with a `db.json` file storing contact records.
- Implemented a REST Assured test that sends a **DELETE request** to the endpoint:


- Verified the server response using **HTTP status 200 OK** to confirm successful deletion.

### ✅ Outcome
The AddressBook system can now delete contact records from an external JSON server using REST API calls executed from automated tests, enabling **verification of contact deletion functionality**.

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
│   │   │   ├── dto
│   │   │   │   └── ContactDTO.java
│   │   │   │
│   │   │   ├── model
│   │   │   │   ├── AddressBook.java
│   │   │   │   └── Contact.java
│   │   │   │
│   │   │   ├── repository
│   │   │   │   └── ContactRepository.java
│   │   │   │
│   │   │   ├── service
│   │   │   │   └── AddressBookService.java
│   │   │   │
│   │   │   ├── storage
│   │   │   │   ├── ContactStorage.java
│   │   │   │   ├── CSVStorage.java
│   │   │   │   ├── FileStorage.java
│   │   │   │   └── JSONStorage.java
│   │   │   │
│   │   │   ├── threads
│   │   │   │   └── AddContactTask.java
│   │   │   │
│   │   │   ├── util
│   │   │   │   ├── CSVUtil.java
│   │   │   │   ├── FileUtil.java
│   │   │   │   └── JSONUtil.java
│   │   │   │
│   │   │   └── AddressBookApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│       └── java/com/addressbookapp
│           ├── AddressbookappApplicationTests.java
│           ├── AddressBookServiceTest.java
│           ├── ContactRepositoryTest.java
│           └── ContactTest.java
│           └── AddressBookJsonServerTest.java
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
