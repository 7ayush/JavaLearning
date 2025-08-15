<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

***
## Answers to Practice \& Quiz on Classes and Objects

### **Practice Answer**

Here is the complete code for the `Dog` class and a `Main` class to test it.

**`Dog.java` file:**

```java
// 1. Create a class named Dog
public class Dog {
    // 2. Add fields for name, breed, and age
    String name;
    String breed;
    int age;

    // 3. Add a method named bark()
    public void bark() {
        System.out.println("Woof! Woof!");
    }

    // 4. Add a method to display info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Breed: " + breed);
        System.out.println("Age: " + age);
    }
}
```

**`Main.java` file:**

```java
public class Main {
    public static void main(String[] args) {
        // 5. Create two different Dog objects
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        // Set properties for the first dog
        dog1.name = "Buddy";
        dog1.breed = "Golden Retriever";
        dog1.age = 5;

        // Set properties for the second dog
        dog2.name = "Lucy";
        dog2.breed = "Poodle";
        dog2.age = 3;

        // Call methods for the first dog
        System.out.println("--- Dog 1 Info ---");
        dog1.displayInfo();
        dog1.bark();

        System.out.println("\n--- Dog 2 Info ---");
        // Call methods for the second dog
        dog2.displayInfo();
        dog2.bark();
    }
}
```

**Output:**

```
--- Dog 1 Info ---
Name: Buddy
Breed: Golden Retriever
Age: 5
Woof! Woof!

--- Dog 2 Info ---
Name: Lucy
Breed: Poodle
Age: 3
Woof! Woof!
```


***

### **Quiz Answers**

#### 1. **In OOP, what is the difference between a class and an object?**
A **class** is a blueprint or template that defines properties and methods. An **object** is an actual, concrete instance created from that class blueprint.
#### 2. **What keyword do you use to create an instance of a class?**
The `new` keyword is used to create (instantiate) an object.
#### 3. **What are the "state" and "behavior" of an object represented by in a Java class?**
    * **State** is represented by **fields** (also called instance variables).
    * **Behavior** is represented by **methods**.
#### 4. **If you have an object named `myCar` of a `Car` class, how would you call its `drive()` method?**
You would use the dot operator: `myCar.drive();`
#### 5. **Why is a field like `isOn` in the `Lamp` class called an "instance variable"?**
It's called an "instance variable" because each **instance** (object) of the class gets its own, separate copy of that variable. Changing the value of `isOn` for one `Lamp` object does not affect the `isOn` value of another `Lamp` object.
