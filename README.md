# 🚗 Parking Lot Management System (Console-Based Java Application)

## 📌 Project Overview

The **Parking Lot Management System** is a console-based Java application developed by applying **Object-Oriented Programming (OOP)** principles and **Low-Level Design (LLD)** concepts.

The application simulates the workflow of a real-world parking lot where vehicles enter, are assigned an available parking slot based on their type, receive a parking ticket, and later exit after the parking fee is calculated.

The primary objective of this project is to understand how to model real-world entities into software components while maintaining a clean, scalable, and maintainable architecture.

---

# 🎯 Features

* Park different types of vehicles

  * Car
  * Bike
  * Truck
* Automatic parking slot allocation
* Parking slot availability management
* Parking ticket generation
* Parking fee calculation based on parking duration
* Vehicle exit process
* Display available parking slots
* Layered Architecture
* Factory Pattern for Vehicle Creation
* Object-Oriented Design using SOLID principles

---

# 🛠 Tech Stack

* Java
* Object-Oriented Programming (OOP)
* Low-Level Design (LLD)
* Collections Framework
* Java Time API (`LocalDateTime`, `Duration`)

---

# 🏗 Project Architecture

The project follows a layered architecture to separate responsibilities.

```text
                   User
                     │
                     ▼
              ParkingLotController
                     │
                     ▼
              ParkingLotService
                     │
                     ▼
            ParkingLotRepository
                     │
                     ▼
                 ParkingLot
                     │
      ┌──────────────┴──────────────┐
      ▼                             ▼
 ParkingFloor                 ParkingTicket
      │
      ▼
 ParkingSlot
      │
      ▼
   Vehicle
      │
 ┌────┼────┐
 ▼    ▼    ▼
Car  Bike Truck
```

Each layer has a single responsibility, making the application easy to maintain and extend.

---

# 🚘 Parking Flow

### Vehicle Entry

1. User selects **Park Vehicle**.
2. User enters:

   * Vehicle Type
   * Registration Number
   * Owner Name
   * Vehicle Color

3. Controller creates the corresponding vehicle using `VehicleFactory`.
4. ParkingLot searches every floor for a compatible available parking slot.
5. If a slot is available:

   * Vehicle is parked.
   * Slot becomes occupied.
   * Parking Ticket is generated.

6. Ticket details are displayed to the user.

---

### Vehicle Exit

1. User enters the Parking Ticket ID.
2. System verifies that the ticket exists and is still ACTIVE.
3. Parking slot is released.
4. Exit time is recorded.
5. Parking duration is calculated.
6. Parking fee is calculated.
7. Ticket status becomes CLOSED.

---

# 🧠 OOP Concepts Used

## Encapsulation

Each class manages its own data using private fields and public methods.

Examples:

* ParkingSlot
* ParkingTicket
* Vehicle

---

## Inheritance

All vehicle types inherit from the abstract `Vehicle` class.

```text
Vehicle
│
├── Car
├── Bike
└── Truck
```

---

## Polymorphism

The application works with the parent reference:

```java
Vehicle vehicle = VehicleFactory.createVehicle(...);
```

allowing different vehicle implementations to be handled uniformly.

---

## Abstraction

The abstract `Vehicle` class provides common properties while concrete vehicle classes implement specific vehicle types.

---

# 📚 Low-Level Design Concepts Applied

* Single Responsibility Principle (SRP)
* Composition
* Factory Pattern
* Layered Architecture
* Domain Modeling
* Separation of Concerns

---

# 🔍 Class Responsibilities

### ParkingLot

* Owns parking floors
* Owns parking tickets
* Coordinates vehicle parking
* Coordinates vehicle exit

---

### ParkingFloor

* Owns parking slots
* Searches for an available slot

---

### ParkingSlot

* Knows whether it is occupied
* Parks a vehicle
* Removes a vehicle

---

### ParkingTicket

* Stores ticket information
* Stores entry time
* Stores exit time
* Calculates parking fee
* Maintains ticket status

---

### VehicleFactory

Responsible for creating the appropriate Vehicle object based on the selected vehicle type.

---

### Repository

Acts as an in-memory storage layer for the Parking Lot.

---

### Service

Implements business operations by coordinating between the Repository and the domain model.

---

### Controller

Handles user interaction through the console and delegates business operations to the Service layer.

---

# 💰 Parking Fee Calculation

Parking fee is calculated using the parking duration.

Current implementation:

* Minimum charge = 1 minute
* Rate = ₹10 per minute (used for testing purpose)

This logic can easily be extended to support dynamic pricing.

---

# ▶️ How to Run

1. Clone the repository.

```bash
git clone <repository-url>
```

2. Open the project in IntelliJ IDEA (or any Java IDE).

3. Build the project.

4. Run `Main.java`.

5. Use the console menu to:

   * Park a Vehicle
   * Exit a Vehicle
   * Display Available Slots

---

# 🎓 Learning Outcomes

This project helped me gain practical experience with:

* Object-Oriented Programming
* Low-Level Design
* Designing real-world entities
* Applying SOLID principles
* Layered Architecture
* Factory Pattern
* Responsibility assignment
* Java Collections
* Console application development
* Writing maintainable and extensible Java code

---
