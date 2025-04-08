
# Java Todo List Database

## Description

This is a simple Todo List application written in Java that interacts with a MySQL database. The app uses the terminal as its interface and provides basic functionalities to manage your todo tasks:

### Features:

- ✅ Show all todo list
- ➕ Add new todo item
- ❌ Remove todo item

---

## Tech Stack Used

- **Java** (JDK 8 or higher)
- **MySQL**
- **MySQL Connector/J** (JDBC driver)

---

## Database Configuration

Make sure you have a MySQL server running and create a database named `java_oop_database`.

### SQL to Create Database and Table:

```sql
CREATE DATABASE java_oop_database;

USE java_oop_database;

CREATE TABLE `todo_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `todo` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

---

## System Requirements

- Java JDK **version 8 or higher**
- MySQL Server
- MySQL Connector/J (JDBC)

---

## Installation

1. **Clone this repository**:

   ```bash
   git clone https://github.com/anandaadam/java-todo-list-database
   ```

2. **Go to project directory**:

   ```bash
   cd java-todo-list-database
   ```

3. **Add MySQL JDBC Connector to your classpath**:  
   Download the MySQL Connector/J from [official site](https://dev.mysql.com/downloads/connector/j/) or use your build tool if applicable (e.g., Maven, Gradle).

---

## Configure Database Connection

Make sure to update your database configuration in the code (usually found in a class like `DatabaseConnection.java`) with your own credentials:

```java
String url = "jdbc:mysql://localhost:3306/java_oop_database";
String username = "your_mysql_username";
String password = "your_mysql_password";
```

---

## Run The Application

You can compile and run the app using the terminal or your preferred IDE:

### Compile:

```bash
javac -cp .:mysql-connector-java-8.0.xx.jar *.java
```

### Run:

```bash
java -cp .:mysql-connector-java-8.0.xx.jar Main
```

> ⚠️ Replace `mysql-connector-java-8.0.xx.jar` with the actual file name of your connector.

---

## Example Usage

```
===== TODO LIST =====
1. Learn Java
2. Build Todo App
3. Push to GitHub

===== MENU =====
1. Show Todo List
2. Add Todo
3. Remove Todo
4. Exit
Choose: 
```

---