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
│   │   │   ├── util── FileUtil.java
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
