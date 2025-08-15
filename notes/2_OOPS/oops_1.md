<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Basics of OOPS, Classes and Objects

Of course. Let's explore the core principles of **Object-Oriented Programming (OOP)** in Java, starting with the most fundamental building blocks: **Classes and Objects**. This paradigm is central to how modern, large-scale Java applications are built.

Here is your comprehensive lesson, referencing the concepts from Programiz.

***

# An Introduction to OOP: Classes and Objects

Object-Oriented Programming (OOP) is a programming style that organizes complex problems into smaller, manageable pieces called **objects**. In Java, everything is associated with classes and objects.

The main idea is to model real-world entities. For example, a bicycle is an object. It has:

* **State**: Its current gear, speed, color.
* **Behavior**: The ability to brake, accelerate, change gears.

OOP translates these concepts into code, making it more organized, reusable, and easier to debug.

## 1. Classes: The Blueprint

A **class** in Java is a blueprint or a prototype from which objects are created. It defines a set of properties (state) and methods (behavior) that will be common to all objects of that type.

Think of a class as an architect's blueprint for a house. The blueprint contains all the details—number of floors, dimensions of rooms, location of windows—but it isn't the house itself. It's just the plan.[^1]

### How to Define a Class

You create a class using the `class` keyword. Inside the class, you define fields (variables) to hold the state and methods (functions) to define the behavior.

**Syntax:**

```java
class ClassName {
    // Fields (variables to store data)
    dataType fieldName;

    // Methods (code to perform operations)
    void methodName() {
        // method body
    }
}
```

**Example: A `Lamp` Class**
Let's create a class for a simple lamp. Its state is whether it's on or off, and its behavior is turning it on or off.

```java
// Saved in a file named Lamp.java
class Lamp {
    // Field (state): stores the value for light
    // true if light is on, false if it's off.
    boolean isOn;

    // Method (behavior): turns the light on
    void turnOn() {
        isOn = true;
        System.out.println("Light on? " + isOn);
    }

    // Method (behavior): turns the light off
    void turnOff() {
        isOn = false;
        System.out.println("Light on? " + isOn);
    }
}
```


## 2. Objects: The Instances

An **object** is a real-world entity created from a class. If the class is the blueprint, the object is the actual house built from it. Using a single class (blueprint), you can create many objects (houses).[^1]

Each object is an **instance** of the class. For our `Lamp` class, we could have a `ledLamp` object and a `halogenLamp` object. Both are lamps, but they are separate, distinct entities.

### How to Create an Object

You create an object using the `new` keyword, followed by a call to the class's **constructor**. A constructor is a special method used to create and initialize objects. It has the same name as the class.

**Syntax:**

```java
ClassName objectName = new ClassName();
```

**Example: Creating `Lamp` Objects**

```java
// This code would typically be in a main method in another class.
public class Main {
    public static void main(String[] args) {
        // Create two objects (instances) of the Lamp class
        Lamp led = new Lamp();
        Lamp halogen = new Lamp();
    }
}
```

Now, `led` and `halogen` are two distinct `Lamp` objects residing in memory.

## 3. Accessing Members of a Class

Once you have an object, you can access its fields and methods using the **dot (`.`) operator**.[^1]

**Syntax:**

```java
// Accessing a field
objectName.fieldName;

// Calling a method
objectName.methodName();
```

**Example: Using the `Lamp` Objects**
Let's expand our `Main` class to interact with our `Lamp` objects.

```java
public class Main {
    public static void main(String[] args) {
        // Create objects led and halogen
        Lamp led = new Lamp();
        Lamp halogen = new Lamp();

        // Turn on the LED lamp by calling its turnOn() method
        led.turnOn();

        // Turn off the halogen lamp by calling its turnOff() method
        halogen.turnOff();

        // We can also access the field directly (though this is often discouraged)
        System.out.println("Is the halogen lamp on? " + halogen.isOn);
    }
}
```

**Output:**

```
Light on? true
Light on? false
Is the halogen lamp on? false
```


## 4. Instance Variables

The fields inside a class, like `isOn` in our `Lamp` example, are called **instance variables**. This is because each **instance** (or object) of the class gets its own, separate copy of these variables.[^1]

In our example:

* When we called `led.turnOn()`, only the `isOn` variable inside the `led` object was set to `true`.
* The `isOn` variable inside the `halogen` object remained unchanged (it was `false` by default).

This is a fundamental concept of OOP: objects maintain their own independent state.

***

## 5. Practice \& Quiz

### Practice

1. Create a class named `Dog`.
2. Add three fields to it: `name` (String), `breed` (String), and `age` (int).
3. Add a method named `bark()` that prints "Woof! Woof!".
4. Add another method `displayInfo()` that prints the dog's name, breed, and age.
5. In a `main` method, create two different `Dog` objects, set their properties, and call both methods for each dog.

### Quiz

1. In OOP, what is the difference between a class and an object?
2. What keyword do you use to create an instance of a class?
3. What are the "state" and "behavior" of an object represented by in a Java class?
4. If you have an object named `myCar` of a `Car` class, how would you call its `drive()` method?
5. Why is a field like `isOn` in the `Lamp` class called an "instance variable"?

<div style="text-align: center">⁂</div>

[^1]: https://www.programiz.com/java-programming/class-objects

