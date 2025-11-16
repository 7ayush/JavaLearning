<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# [https://www.baeldung.com/java-final](https://www.baeldung.com/java-final)

[https://stackoverflow.com/questions/15655012/how-does-the-final-keyword-in-java-work-i-can-still-modify-an-object](https://stackoverflow.com/questions/15655012/how-does-the-final-keyword-in-java-work-i-can-still-modify-an-object)

Now lets discuss this

The `final` keyword in Java is a non-access modifier used to apply restrictions on variables, methods, and classes, making them non-changeable in specific ways. Understanding its precise meaning is crucial for writing robust, predictable, and secure code.

![Comprehensive Java Final Keyword tutorial and reference.](https://ppl-ai-code-interpreter-files.s3.amazonaws.com/web/direct-files/ba32458ae0ab6a3ccabdfa156ec398a1/62150dbe-fd99-4bbf-8b43-6c53d5059625/c9c63d86.png)

Comprehensive Java Final Keyword tutorial and reference.

This lesson covers the `final` keyword's use cases, its relationship with immutability, and common misconceptions, with examples and exercises included.

## The `final` Keyword: Key Applications

The `final` keyword can be applied in three contexts:

### 1. `final` Variables

A `final` variable can only be assigned **once**. After initialization, its value cannot be changed. This makes it effectively a constant.

- **For Primitive Types**: The value itself is made constant.
- **For Reference Types**: The **reference** is made constant. This means the variable cannot be reassigned to point to a different object. However, the internal state of the object it points to **can still be changed**.

**Example: Primitive vs. Reference**

```java
public class FinalVariableExample {
    public static void main(String[] args) {
        // final primitive - value cannot be changed
        final int MAX_ATTEMPTS = 3;
        // MAX_ATTEMPTS = 4; // This would cause a compile-time error

        // final reference - reference cannot be changed
        final StringBuilder message = new StringBuilder("Hello");
        
        // You CAN modify the object's internal state
        message.append(" World!"); 
        System.out.println(message); // Prints: Hello World!
        
        // You CANNOT reassign the reference to a new object
        // message = new StringBuilder("Hi"); // This would cause a compile-time error
    }
}
```


### 2. `final` Methods

A `final` method **cannot be overridden** by a subclass. This is used to enforce a specific implementation and prevent child classes from altering a method's core behavior.

**Example: Preventing Overriding**

```java
class SuperClass {
    // This method cannot be overridden by subclasses
    public final void showBaseImplementation() {
        System.out.println("This is the base implementation.");
    }
}

class SubClass extends SuperClass {
    // @Override
    // public void showBaseImplementation() { // Compile-time error
    //     System.out.println("Trying to override.");
    // }
}
```


### 3. `final` Classes

A `final` class **cannot be extended** (subclassed). This is often done for security reasons or to ensure that the class's behavior remains unchanged. Many core Java library classes, like `String` and `Integer`, are `final`.

**Example: Preventing Inheritance**

```java
// This class cannot be extended
public final class UtilityClass {
    public static void doSomething() {
        System.out.println("Doing something useful.");
    }
}

// class MyUtility extends UtilityClass { } // This would cause a compile-time error
```


## `final` vs. Immutability: A Crucial Distinction

A common point of confusion is the difference between a `final` variable and an **immutable object**.

- **`final`**: A modifier for a **variable** (reference). It ensures the variable will always point to the same object.
- **Immutability**: A property of an **object**. It means the object's internal state cannot be changed after it is created.

**A `final` reference does not make the object it points to immutable.** As seen in the `StringBuilder` example, the `message` variable was `final`, but the `StringBuilder` object itself was still mutable.

**To create a truly immutable object:**

1. Make the class `final` to prevent subclassing.
2. Make all fields `private` and `final`.
3. Do not provide any "setter" methods that modify fields.
4. If a field is a mutable object (like a `List` or a `Date`), ensure you return defensive copies of it in your getter methods.

**Example: An Immutable `User` Class**

```java
public final class User {
    private final String username;
    private final java.util.Date registrationDate;

    public User(String username, java.util.Date registrationDate) {
        this.username = username;
        // Create a defensive copy to prevent external modification
        this.registrationDate = new java.util.Date(registrationDate.getTime());
    }

    public String getUsername() {
        return username;
    }

    // Return a defensive copy, not the original mutable object
    public java.util.Date getRegistrationDate() {
        return new java.util.Date(registrationDate.getTime());
    }
}
```


## Practice \& Quiz

### Practice

1. **Constant Definition**: Create a class `Constants` with a `public static final` variable `APP_VERSION` initialized to `"1.0"`. Try to reassign it in another class and observe the error.
2. **Final Method**: Create a `Vehicle` class with a `final` method `getVIN()`. Create a `Car` subclass and try to override `getVIN()`.
3. **Reference vs. State**: Create a `final` `ArrayList` of strings. Add a new string to the list. Then, try to reassign the list variable to a new `ArrayList`. Which action is allowed and which is not?

### Quiz

1. What does the `final` keyword prevent when applied to a variable?
2. Can you change the state of an object that a `final` reference variable points to?
3. What is the main purpose of declaring a method as `final`?
4. Why is the `String` class in Java declared as `final`?
5. True or False: Declaring a class's fields as `private` and `final` is sufficient to make the class immutable.

***

## Answers to Practice \& Quiz

### **Practice Answers**

1. **Constant Definition**: Reassigning `Constants.APP_VERSION` will cause a compile-time error because it is a `final` variable.
2. **Final Method**: The attempt to override `getVIN()` in the `Car` subclass will result in a compile-time error.
3. **Reference vs. State**:
    - Adding a string to the `final ArrayList` **is allowed** because it modifies the internal state of the object.
    - Reassigning the `ArrayList` variable to a new `ArrayList` **is not allowed** and will cause a compile-time error.

### **Quiz Answers**

1. It prevents the variable from being **reassigned** to a new value or a new object reference after its initial assignment.
2. **Yes**, you can change the internal state of a mutable object (e.g., by calling its methods), even if the reference variable pointing to it is `final`.
3. The main purpose is to **prevent method overriding** in subclasses, ensuring the method's implementation remains consistent.
4. The `String` class is `final` to ensure its **immutability and security**. Since strings are used extensively (e.g., as keys in maps, in security credentials), making them unchangeable prevents unpredictable behavior and potential security vulnerabilities.
5. **False**. If the class has fields that are mutable objects (like `java.util.Date` or `ArrayList`), you must also handle them carefully (e.g., by making defensive copies) to ensure true immutability.
<span style="display:none">[^1][^10][^11][^12][^13][^14][^15][^16][^17][^18][^19][^2][^20][^3][^4][^5][^6][^7][^8][^9]</span>

<div style="text-align: center">⁂</div>

[^1]: https://www.baeldung.com/java-final

[^2]: https://www.baeldung.com/java-final-performance

[^3]: https://stackoverflow.com/questions/73847699/why-are-keywords-like-final-and-mut-necessary

[^4]: https://glasp.co/discover?url=www.baeldung.com%2Fjava-static-final-order

[^5]: https://www.geeksforgeeks.org/java/final-keyword-in-java/

[^6]: https://www.geekster.in/articles/final-keyword-in-java/

[^7]: https://www.tutorialspoint.com/final-vs-immutability-in-java

[^8]: https://baeldung3.rssing.com/chan-58647577/all_p67.html

[^9]: https://unstop.com/blog/final-keyword-in-java

[^10]: https://www.geeksforgeeks.org/java/final-vs-immutability-java/

[^11]: https://www.reddit.com/r/learnjava/comments/1ffoa9p/using_final_in_method_parameters_your_opinion/

[^12]: https://www.w3schools.com/java/ref_keyword_final.asp

[^13]: https://stackoverflow.com/questions/34087724/what-is-the-difference-between-immutable-and-final-in-java

[^14]: https://stackoverflow.com/questions/15655012/how-does-the-final-keyword-in-java-work-i-can-still-modify-an-object

[^15]: https://www.reddit.com/r/java/comments/azryu6/final_vs_immutable_data_structures_in_java/

[^16]: https://www.programiz.com/java-programming/final-keyword

[^17]: https://coderanch.com/t/755336/java/final-objects

[^18]: https://www.tutorialspoint.com/java/final_keyword_in_java.htm

[^19]: https://www.baeldung.com/java-immutable-object

[^20]: https://scalablehuman.com/2024/10/04/understanding-immutability-in-java-the-role-of-final-variables/

