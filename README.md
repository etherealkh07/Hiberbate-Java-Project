# Hibernate-Java-Project

This project demonstrates **CRUD (Create, Read, Update, Delete)** operations using **Hibernate ORM** with a **MySQL database**. It includes operations for managing two entities: `Company` and `Employee`.

---

## Features

- **Save**: Add new Company or Employee records.
- **Update**: Modify existing Company or Employee details.
- **Fetch**: Retrieve and display all records.
- **Delete**: Remove records from the database with proper relationship handling.

---

## Prerequisites

- **JDK**: Version 8 or above
- **Apache Maven**: For dependency management
- **MySQL**: As the database
- **Hibernate**: Version 6.5.2
- **IDE**: IntelliJ, Eclipse, or similar

---

## Configuration

Update your `persistence.xml` file:
```xml
<persistence xmlns="https://jakarta.ee/xml/ns/persistence" version="3.1">
    <persistence-unit name="aakash">
        <properties>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/hibernate"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="your_password"/>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>

---

