# 🚗 Parking Lot System - Low Level Design (LLD)

![Java](https://img.shields.io/badge/Java-17-orange)
![Design](https://img.shields.io/badge/Design-LLD-blue)
![Patterns](https://img.shields.io/badge/Patterns-Factory%20%7C%20Strategy-green)

---

# 📌 Problem Statement

Design a Parking Lot System that supports:

- Multiple Floors
- Multiple Parking Spot Types
    - Bike Spot
    - Car Spot
    - Truck Spot
- Vehicle Entry
- Vehicle Exit
- Ticket Generation
- Parking Fee Calculation
- Extensible Spot Allocation Strategy

---

# 🎯 Functional Requirements

### Vehicle Entry

- Vehicle enters parking lot
- Appropriate parking spot should be allocated
- Ticket should be generated

### Vehicle Exit

- Vehicle exits parking lot
- Parking fee should be calculated
- Spot should be released

### Spot Allocation

Support multiple allocation strategies:

- Nearest Available Spot
- Random Available Spot
- VIP Spot (Future)

---

# 🚫 Non Functional Requirements

- Extensible Design
- Low Coupling
- High Cohesion
- Thread Safe Spot Allocation
- Easy to Add New Vehicle Types
- Easy to Add New Parking Strategies

---

# 🏗️ High Level Design

```text
Vehicle Entry
      |
      V
Parking Service
      |
      V
Parking Strategy
      |
      V
Find Available Spot
      |
      V
Generate Ticket
      |
      V
Store Ticket
```

---

# 📂 Project Structure

```text
parkinglot/

├── model
│   ├── Vehicle.java
│   ├── VehicleType.java
│   ├── Car.java
│   ├── Bike.java
│   ├── Truck.java
│   │
│   ├── SpotType.java
│   ├── ParkingSpot.java
│   ├── CarSpot.java
│   ├── BikeSpot.java
│   ├── TruckSpot.java
│   │
│   ├── Floor.java
│   ├── ParkingLot.java
│   └── Ticket.java
│
├── strategy
│   ├── ParkingStrategy.java
│   ├── NearestSpotStrategy.java
│   └── RandomSpotStrategy.java
│
├── factory
│   └── VehicleFactory.java
│
├── service
│   └── ParkingService.java
│
├── exception
│   ├── ParkingFullException.java
│   ├── InvalidTicketException.java
│   └── SpotNotFoundException.java
│
└── Main.java
```

---

# 🧩 Class Diagram

```text
                    Vehicle
                       |
        --------------------------------
        |              |              |
       Car           Bike          Truck


                ParkingSpot
                     |
      -----------------------------------
      |                |               |
   BikeSpot        CarSpot        TruckSpot


                ParkingLot
                    |
             List<Floor>
                    |
             List<ParkingSpot>


                  Ticket
                  /   \
                 /     \
            Vehicle   ParkingSpot
```

---

# 🎨 Design Patterns Used

## 1️⃣ Factory Pattern

### Purpose

Create Vehicle objects without exposing creation logic.

### Example

```java
Vehicle vehicle =
        VehicleFactory.createVehicle(
                VehicleType.CAR,
                "MH12AB1234");
```

### Benefits

- Centralized Object Creation
- Easy Extensibility
- Loose Coupling

---

## 2️⃣ Strategy Pattern

### Purpose

Support multiple parking spot allocation algorithms.

### Example

```java
ParkingStrategy strategy =
        new NearestSpotStrategy();
```

### Current Strategies

- NearestSpotStrategy
- RandomSpotStrategy

### Future Strategies

- VIPSpotStrategy
- EVSpotStrategy
- HandicappedSpotStrategy

### Benefits

- Open Closed Principle
- Easy to Add New Algorithms

---

# 📚 SOLID Principles Applied

| Principle | Usage |
|------------|------------|
| Single Responsibility | Model and Service Separation |
| Open Closed | Strategy Pattern |
| Liskov Substitution | CarSpot, BikeSpot, TruckSpot |
| Interface Segregation | Small Focused Interfaces |
| Dependency Inversion | ParkingService depends on ParkingStrategy |

---

# 🗄️ Database Schema

## parking_lot

| Column | Type | Constraint |
|----------|----------|----------|
| id | BIGINT | PK |
| name | VARCHAR(100) | NOT NULL |
| created_at | TIMESTAMP | |

---

## floor

| Column | Type | Constraint |
|----------|----------|----------|
| id | BIGINT | PK |
| parking_lot_id | BIGINT | FK |
| floor_number | INT | NOT NULL |

---

## parking_spot

| Column | Type | Constraint |
|----------|----------|----------|
| id | BIGINT | PK |
| floor_id | BIGINT | FK |
| spot_number | VARCHAR(20) | |
| spot_type | VARCHAR(20) | |
| occupied | BOOLEAN | |

---

## vehicle

| Column | Type | Constraint |
|----------|----------|----------|
| id | BIGINT | PK |
| vehicle_number | VARCHAR(20) | UNIQUE |
| vehicle_type | VARCHAR(20) | |
| created_at | TIMESTAMP | |

---

## ticket

| Column | Type | Constraint |
|----------|----------|----------|
| id | BIGINT | PK |
| vehicle_id | BIGINT | FK |
| parking_spot_id | BIGINT | FK |
| entry_time | TIMESTAMP | |
| exit_time | TIMESTAMP | |
| total_amount | DECIMAL(10,2) | |
| status | VARCHAR(20) | ACTIVE / CLOSED |

---

# 🔗 Entity Relationship Diagram

```text
ParkingLot
    |
    | 1 : N
    V
Floor
    |
    | 1 : N
    V
ParkingSpot


Vehicle
    |
    | 1 : N
    V
Ticket
    |
    | N : 1
    V
ParkingSpot
```

---

# 🚀 REST APIs

## 1. Park Vehicle

### Endpoint

```http
POST /api/v1/parking/entry
```

### Request

```json
{
  "vehicleNumber": "MH12AB1234",
  "vehicleType": "CAR"
}
```

### Response

```json
{
  "ticketId": 1,
  "spotId": 10,
  "entryTime": "2026-06-07T10:00:00"
}
```

---

## 2. Exit Vehicle

### Endpoint

```http
POST /api/v1/parking/exit
```

### Request

```json
{
  "ticketId": 1
}
```

### Response

```json
{
  "ticketId": 1,
  "amount": 100.00,
  "exitTime": "2026-06-07T12:00:00"
}
```

---

## 3. Get Ticket Details

### Endpoint

```http
GET /api/v1/tickets/{ticketId}
```

### Response

```json
{
  "ticketId": 1,
  "vehicleNumber": "MH12AB1234",
  "spotId": 10,
  "entryTime": "2026-06-07T10:00:00"
}
```

---

## 4. Get Available Spots

### Endpoint

```http
GET /api/v1/spots/available?type=CAR
```

### Response

```json
{
  "availableSpots": 25
}
```

---

## 5. Get Parking Lot Status

### Endpoint

```http
GET /api/v1/parking/status
```

### Response

```json
{
  "totalSpots": 100,
  "occupiedSpots": 75,
  "availableSpots": 25
}
```

---

# 🔄 Parking Flow

```text
Vehicle Entry
      |
      V
VehicleFactory
      |
      V
ParkingService
      |
      V
ParkingStrategy
      |
      V
ParkingSpot Found
      |
      V
Ticket Generated
      |
      V
Store Ticket
```

---

# 🔒 Concurrency Handling

## Problem

Two vehicles may try to occupy the same parking spot simultaneously.

```text
Vehicle A
Vehicle B

Both trying Spot #10
```

## Solution

Use:

```java
synchronized
```

or

```java
ReentrantLock
```

during spot allocation.

### Interview Answer

> Spot allocation should be atomic to prevent race conditions and double booking of parking spots.

---

## 👨‍💻 Author

### Onkar Bhogale

Backend Engineer | Java | Spring Boot | System Design | Low Level Design

### Connect With Me

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Onkar%20Bhogale-blue?logo=linkedin)](https://www.linkedin.com/in/onkar-bhogale/)
