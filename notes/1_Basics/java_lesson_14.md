<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Basics of OOPS in java

https://jenkov.com/tutorials/java/classes.html

**Object-Oriented Programming (OOP)**. We'll start with the most fundamental concept: **Classes and Objects**.

This lesson will break down what classes are, how they serve as blueprints, and how you can create objects (instances) from them.

***

# An Introduction to Object-Oriented Programming (OOP) in Java

Object-Oriented Programming is a programming paradigm based on the concept of "objects," which can contain data in the form of **fields** (often known as attributes or properties) and code in the form of **methods** (often known as procedures or functions).

The core idea is to model real-world things (like a car, a user, or a bank account) as objects in your code. This makes your programs more organized, easier to manage, and reusable. A Java application is typically composed of many interacting objects.[^1]

## 1. Classes: The Blueprint

A **Java Class** is a blueprint or template for creating objects. It defines a set of properties and behaviors that will be common to all objects of that type. A class is a coherent unit of code that groups related data and actions together.[^1]

For example, if you wanted to model cars, you would create a `Car` class. This class would define:

* **Fields (Data)**: What properties does a car have? (e.g., `brand`, `model`, `color`, `speed`).
* **Methods (Behaviors)**: What can a car do? (e.g., `startEngine()`, `accelerate()`, `brake()`).


### Defining a Class in Java

Creating a class is simple. You use the `class` keyword followed by the class name. By convention, class names in Java start with a capital letter. This definition should be saved in a `.java` file with the same name (e.g., `Car.java`).[^1]

**Syntax:**

```java
public class ClassName {
    // Fields (variables)
    // Constructors
    // Methods
}
```

**Example: The `Car` Class**

```java
public class Car {
    // Fields: The data or attributes of a Car
    String brand;
    String model;
    String color;
    int year;

    // This is a basic class definition with only fields.
}
```


## 2. Objects: The Real Thing

An **Object** is an **instance** of a class. If a class is the blueprint, an object is the actual house built from that blueprint. You can create many objects from a single class, each with its own unique state (data).[^1]

For our `Car` class, an object would be a specific car, like "a red 2023 Tesla Model S" or "a blue 2020 Ford Mustang."

### Creating (Instantiating) an Object

To create an object from a class, you use the `new` keyword. This process is called **instantiation**.[^1]

**Syntax:**

```java
ClassName objectName = new ClassName();
```

**Example: Creating Car Objects**

```java
public class Garage {
    public static void main(String[] args) {
        // Create two Car objects (instances of the Car class)
        Car myCar = new Car();
        Car friendsCar = new Car();

        // Now we have two distinct Car objects in memory.
    }
}
```


## 3. The Building Blocks of a Class

A well-defined class typically contains fields, constructors, and methods.[^1]

### A. Fields

Fields are variables declared inside a class that hold the state of an object. Each object gets its own copy of these fields.[^1]

```java
public class Car {
    // Fields
    String brand;
    String model;
    String color;
}
```

You can access and modify an object's fields using dot notation (`.`).

```java
Car myCar = new Car();
myCar.brand = "Tesla";
myCar.model = "Model Y";
myCar.color = "White";

System.out.println("My car is a " + myCar.color + " " + myCar.brand);
```


### B. Constructors

A **constructor** is a special method that is called when an object is created. Its primary purpose is to initialize the object's fields. A constructor has the same name as the class and no return type.[^1]

**Example: Adding a Constructor to `Car`**

```java
public class Car {
    String brand;
    String model;

    // Constructor to initialize the fields
    public Car(String brand, String model) {
        this.brand = brand; // 'this.brand' refers to the field, 'brand' refers to the parameter
        this.model = model;
    }
}
```

Now, you can create objects more cleanly:

```java
Car car1 = new Car("Toyota", "Corolla");
Car car2 = new Car("Honda", "Civic");
```


### C. Methods

**Methods** define the behavior of an object—the actions it can perform. They operate on the object's fields and can take parameters to perform calculations or manipulations.[^1]

**Example: Adding Methods to `Car`**

```java
public class Car {
    String brand;
    String model;
    boolean isEngineOn;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false; // Engine is off by default
    }

    // Method to start the engine
    public void startEngine() {
        isEngineOn = true;
        System.out.println("The engine of the " + brand + " is now on.");
    }

    // Method to display information
    public void displayInfo() {
        System.out.println("Car Info: " + brand + " " + model);
    }
}
```

**Using the Methods:**

```java
Car myCar = new Car("Ford", "Mustang");
myCar.displayInfo();  // Output: Car Info: Ford Mustang
myCar.startEngine();  // Output: The engine of the Ford is now on.
```


***

## 4. A Complete Example

Here is a final, complete example that ties everything together.

**`Car.java` file:**

```java
public class Car {
    // Fields
    String brand;
    String model;
    int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Method
    public void displayDetails() {
        System.out.println("Car: " + this.year + " " + this.brand + " " + this.model);
    }
}
```

**`Main.java` file:**

```java
public class Main {
    public static void main(String[] args) {
        // Create an object of the Car class
        Car car1 = new Car("Porsche", "911", 2023);
        
        // Create another object
        Car car2 = new Car("Jeep", "Wrangler", 2022);

        // Call the method on each object
        car1.displayDetails(); // Output: Car: 2023 Porsche 911
        car2.displayDetails(); // Output: Car: 2022 Jeep Wrangler
    }
}
```


***

## 5. Practice \& Quiz

### Practice

1. Create a `Book` class with fields for `title` (String), `author` (String), and `pageCount` (int).
2. Add a constructor to the `Book` class that initializes all three fields.
3. Add a method `getSummary()` to the `Book` class that prints a summary like: "Title: [title], Author: [author], Pages: [pageCount]".
4. In a `main` method, create two different `Book` objects and call the `getSummary()` method on both.

### Quiz

1. What is the main difference between a class and an object?
2. What is the keyword used to create an object from a class?
3. What is the primary purpose of a constructor?
4. If a class is named `Student`, what must its constructor be named?
5. How do you access a field or method of an object?

<div style="text-align: center">⁂</div>

[^1]: https://jenkov.com/tutorials/java/classes.html

