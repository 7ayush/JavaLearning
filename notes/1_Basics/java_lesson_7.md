<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Java Variables and Scopes

Understanding **variables** and their **scope** in Java is essential for writing effective and bug-free code. This lesson covers the fundamentals of Java variables, their types, how to declare and use them, and the different scopes that variables can have within a Java program.

***

## 1. Java Variables: Overview

A **variable** in Java is a named container that stores data values in memory. Every variable has:

- A **data type** (which defines the kind of data it holds, e.g., `int`, `String`).
- A **name** (identifier following Java naming rules).
- A **value** (the data assigned to the variable).


### Declaring Variables

The syntax to declare a variable is:

```java
dataType variableName;
```

Optionally, you can initialize the variable when declaring:

```java
dataType variableName = value;
```


### Examples

```java
int myNum;          // Declaration
myNum = 15;         // Initialization

int age = 30;       // Declaration + Initialization together
String name = "Alice";
double pi = 3.14159;
```

Reassigning a new value is allowed:

```java
int score = 100;
score = 150;        // score is now 150
```


***

## 2. Types of Variables in Java

Java variables generally fall into these categories:

### 2.1 Local Variables

- Declared **inside a method**, constructor, or block.
- Only accessible **within that method or block**.
- Must be initialized before use.

Example:

```java
public void greet() {
    String message = "Hello";
    System.out.println(message);
}
// 'message' is not accessible outside greet()
```


### 2.2 Instance Variables (Non-static fields)

- Declared inside a class but **outside any method**, without `static`.
- Each object (instance) of the class has its own copy.
- Default initialized to zero, false, or null if not explicitly initialized.

Example:

```java
class Person {
    String name;    // instance variable
    int age;
}
```


### 2.3 Static Variables (Class variables)

- Declared inside a class with the `static` keyword.
- Only one copy exists, shared among all instances of the class.
- Useful for constants or shared data.

Example:

```java
class MyClass {
    static int count = 0;
}
```


***

## 3. Variable Scope in Java

**Scope** refers to the part of the program where a variable is accessible.

### 3.1 Method (Local) Scope

Variables declared inside a method exist and are accessible only **within that method**.

```java
void myMethod() {
    int localVar = 10;  // localVar is only accessible here
}
```

Trying to use `localVar` outside will cause a compile-time error.

### 3.2 Block (Loop/Bracket) Scope

Variables declared within a block `{ ... }` like loops or conditionals, only exist inside that block.

```java
if (true) {
    int blockVar = 20; // blockVar accessible only here
}
// Outside, blockVar is not accessible
```


### 3.3 Class Scope

Instance and static variables have class-level scope. Instance variables belong to objects; static variables belong to the class.

They are accessible throughout the class (and beyond depending on access modifiers).

### 3.4 Variable Shadowing

If a variable declared in an inner scope (e.g., a local variable) has the same name as one in an outer scope (e.g., instance variable), the inner one **shadows** the outer one within that scope.

Example:

```java
class Example {
    int value = 10; // instance variable

    void method() {
        int value = 20; // local variable shadows instance variable
        System.out.println(value); // prints 20
        System.out.println(this.value); // prints 10
    }
}
```

Use `this.` to explicitly reference the instance variable if shadowed.

***

## 4. Key Rules and Naming Conventions for Variables

- Variable names are **case-sensitive**.
- Must start with a letter, `$` or `_`, but typically start with a letter.
- Can contain letters, digits, `_`, `$`.
- Cannot use Java reserved keywords.
- By convention, use **camelCase** (`myVariable`, `userName`).
- Constants (static final) use **ALL_CAPS_WITH_UNDERSCORES**.

***

## 5. Practical Code Examples

```java
public class VariableExample {
    // Instance variable
    int instanceVar = 100;

    // Static variable
    static int staticVar = 500;

    public void demoScope() {
        // Local variable
        int localVar = 50;

        if (localVar > 0) {
            // Block-scoped variable
            int blockVar = 25;
            System.out.println("Block variable: " + blockVar);
        }
        // blockVar is not accessible here (uncommenting next line causes error)
        // System.out.println(blockVar);

        System.out.println("Local variable: " + localVar);
    }

    public static void main(String[] args) {
        VariableExample obj = new VariableExample();
        obj.demoScope();

        System.out.println("Instance variable: " + obj.instanceVar);
        System.out.println("Static variable: " + VariableExample.staticVar);
    }
}
```


***

## 6. Summary Table of Variable Scopes

| Scope Type | Declared Where | Accessibility | Lifetime |
| :-- | :-- | :-- | :-- |
| Local | Inside methods/blocks | Only within the method/block | Exists during method/block execution |
| Instance | Inside class (no static) | Entire class, per object | Tied to object's lifetime |
| Static | Inside class, static | Entire class, shared by all objects | As long as class is loaded |
| Block | Inside `{ }` blocks | Only inside the block | During block execution |


***

## 7. Practice \& Quiz

### Practice

1. Declare an instance variable and a static variable in a class. Create multiple objects and print their values to observe shared vs unique behavior.
2. Write a method with a local variable and a nested block variable. Print the variables to understand their scopes.

### Quiz

1. What is the difference between a local variable and an instance variable?
2. How can you access a shadowed instance variable inside a method?
3. Can a static variable be accessed without creating an object?
4. What is variable shadowing and why can it be confusing?

***

This lesson covers the essentials of **Java variables and their scopes** with examples and explanations to help you master these core concepts.

You can copy this content into a `.md` file for your notes. If you want, I can also provide more detailed examples or exercises on any part.

Would you like me to prepare that now?

<div style="text-align: center">⁂</div>

[^1]: https://jenkov.com/tutorials/java/variables.html

[^2]: https://www.baeldung.com/java-variable-scope

[^3]: https://www.w3schools.com/java/java_variables.asp

[^4]: https://www.geeksforgeeks.org/java/variables-in-java/

[^5]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html

[^6]: https://www.tutorialspoint.com/java/java_variable_types.htm

[^7]: https://beginnersbook.com/2017/08/variables-in-java/

[^8]: https://www.baeldung.com/cs/closure

[^9]: https://www.geeksforgeeks.org/java/java-data-types/

[^10]: https://www.youtube.com/watch?v=so1iUWaLmKA

[^11]: https://www.w3schools.com/java/java_data_types.asp

[^12]: https://www.codewithharry.com/tutorial/java-variables

[^13]: https://www.baeldung.com/spring-bean-scopes

[^14]: https://www.learnjavaonline.org/en/Variables_and_Types

[^15]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variablesummary.html

[^16]: https://www.baeldung.com/java-20-scoped-values

[^17]: https://www.geekster.in/articles/java-variables/

[^18]: https://www.w3schools.com/java/java_variables_reallife.asp

[^19]: https://www.baeldung.com/java-postman-variables

[^20]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

[^21]: https://www.baeldung.com/java-variable-method-hiding

