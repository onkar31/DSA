# 🧮 Calculator System - Low Level Design (LLD)

![Java](https://img.shields.io/badge/Java-17-orange)
![Design](https://img.shields.io/badge/Design-SOLID-blue)

---

# 📌 Problem Statement

Design a Calculator System that follows all SOLID principles and supports:

* Addition
* Subtraction
* Multiplication
* Division
* Easy addition of new operations

---

# 🎯 Functional Requirements

* Perform arithmetic operations
* Support extensible operation types
* Follow SOLID principles
* Easy to maintain and test

---

# 🏗️ Project Structure

```text
calculator/

├── operation
│   ├── Operation.java
│   ├── Addition.java
│   ├── Subtraction.java
│   ├── Multiplication.java
│   └── Division.java
│
├── factory
│   └── OperationFactory.java
│
├── service
│   └── CalculatorService.java
│
└── Main.java
```

---

# 🧩 Class Diagram

```text
                Operation
                     |
      --------------------------------
      |        |         |          |
 Addition  Subtraction  Multiply  Division


          CalculatorService
                    |
                    V
              Operation
```

---

# 🎨 Design Patterns Used

## Factory Pattern

Creates operation objects without exposing creation logic.

```java
Operation operation =
        OperationFactory.getOperation("+");
```

### Benefits

* Centralized object creation
* Loose coupling
* Easy extensibility

---

# 📚 SOLID Principles Applied

## S - Single Responsibility

Each operation class performs only one operation.

```java
Addition
Subtraction
Multiplication
Division
```

---

## O - Open Closed

New operations can be added without modifying existing code.

Example:

```java
class Modulus implements Operation
```

---

## L - Liskov Substitution

Any implementation can replace the Operation interface.

```java
Operation operation =
        new Addition();
```

```java
Operation operation =
        new Division();
```

---

## I - Interface Segregation

Small focused interface.

```java
public interface Operation {
    double execute(double a, double b);
}
```

---

## D - Dependency Inversion

CalculatorService depends on abstraction.

```java
public double calculate(
        double a,
        double b,
        Operation operation)
```

Not on concrete classes.

---

# 🔄 Execution Flow

```text
User Input
    |
    V
OperationFactory
    |
    V
Operation Object
    |
    V
CalculatorService
    |
    V
Result
```

---

# 🚀 Sample Usage

```java
CalculatorService calculator =
        new CalculatorService();

Operation operation =
        OperationFactory.getOperation("+");

double result =
        calculator.calculate(
                10,
                20,
                operation);

System.out.println(result);
```

### Output

```text
30.0
```

---

# 👨‍💻 Author

### Onkar Bhogale

Backend Engineer | Java | Spring Boot | System Design | Low Level Design

### Connect With Me

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Onkar%20Bhogale-blue?logo=linkedin)](https://www.linkedin.com/in/onkar-bhogale/)

---
