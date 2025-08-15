<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Now https://jenkov.com/tutorials/java/access-modifiers.html

Of course. Let's cover **Java Access Modifiers**, a critical concept for controlling the visibility and accessibility of your classes, fields, and methods. This is essential for building robust and well-encapsulated object-oriented programs.

This lesson is based on the comprehensive Jenkov tutorial on the topic.

***

# Java Access Modifiers: Controlling Visibility

In Java, an **access modifier** is a keyword that specifies which other parts of your code are allowed to access a class, field, constructor, or method. They are a cornerstone of **encapsulation**, an OOP principle that involves bundling data (fields) and the methods that operate on that data within a single unit (a class), and restricting access to some of the object's components.

Java has four access modifiers, listed here from most restrictive to least restrictive:

1. `private`
2. `default` (also known as package-private)
3. `protected`
4. `public`

## 1. `private` Access Modifier

The `private` modifier is the most restrictive. A member marked as `private` is accessible **only from within the same class**. It cannot be seen or used by any other class, not even its own subclasses.[^1]

* **Scope**: Same class only.
* **Use Case**: For internal data and helper methods that should not be exposed to the outside world. This prevents external code from depending on or incorrectly manipulating the internal state of an object.

**Example:**

```java
public class Account {
    private double balance; // This field is private

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            logTransaction(); // Can call a private method
        }
    }

    // A private helper method
    private void logTransaction() {
        System.out.println("Transaction logged for balance: " + this.balance);
    }
}
```

In this example, `balance` can only be changed through the public `deposit` method, giving the class full control over its state.[^1]

## 2. `default` (Package-Private) Access Modifier

If you do not specify any access modifier, Java applies the `default` modifier. A member with default access is accessible only from **within the same Java package**. It is often called "package-private."[^1]

* **Scope**: Same package only.
* **Use Case**: For classes and members that are meant to be used closely together within a specific package but are not part of the public API for external packages.

**Example:**

Let's say we have two classes in the same package `com.myapp.banking`:

**`Account.java`**

```java
package com.myapp.banking;

class AccountDetails { // default access class
    String accountHolderId; // default access field

    void printDetails() { // default access method
        System.out.println("Holder ID: " + accountHolderId);
    }
}
```

**`BankManager.java`**

```java
package com.myapp.banking;

public class BankManager {
    public void viewDetails() {
        AccountDetails details = new AccountDetails();
        details.accountHolderId = "12345"; // Allowed, same package
        details.printDetails(); // Allowed, same package
    }
}
```


## 3. `protected` Access Modifier

The `protected` modifier provides the same access as `default` (package-private), with one important addition: it allows **subclasses to access** the member, even if the subclass is in a different package.[^1]

* **Scope**: Same package **OR** any subclass (regardless of package).
* **Use Case**: For members that are not intended for general public use but need to be accessible to child classes for extension or overriding.

**Example:**

**`BaseController.java` (in package `com.framework`)**

```java
package com.framework;

public class BaseController {
    protected void handleRequest() {
        System.out.println("Base request handling logic.");
    }
}
```

**`UserController.java` (in package `com.myapp`)**

```java
package com.myapp;
import com.framework.BaseController;

public class UserController extends BaseController {
    public void processUser() {
        // Can access the protected method because it's a subclass
        this.handleRequest();
        System.out.println("Handling user-specific request.");
    }
}
```


## 4. `public` Access Modifier

The `public` modifier is the least restrictive. A member marked as `public` is accessible from **anywhere** in the application, in any class and any package.[^1]

* **Scope**: Everywhere.
* **Use Case**: For the main public API of your class—the methods and fields you want everyone to be able to use. The `main` method of an application must be `public`.

**Example:**

```java
public class MathUtils {
    public static final double PI = 3.14159; // Public constant

    public static int add(int a, int b) { // Public method
        return a + b;
    }
}
```


***

## 5. Summary of Access Modifiers

| Modifier | Same Class | Same Package | Subclass (different package) | World (any package) |
| :-- | :--: | :--: | :--: | :--: |
| `private` | **Yes** | No | No | No |
| `default` | **Yes** | **Yes** | No | No |
| `protected` | **Yes** | **Yes** | **Yes** | No |
| `public` | **Yes** | **Yes** | **Yes** | **Yes** |

### Important Rules

* **Top-level classes** can only be `public` or `default` (package-private). A `private` top-level class would be useless as nothing could access it.[^1]
* When a method is **overridden** in a subclass, its access modifier cannot be more restrictive than the one in the superclass. For example, a `protected` method can be overridden as `protected` or `public`, but not `private`.[^1]

***

## 6. Practice \& Quiz

### Practice

1. **Banking System**: You are designing a `BankAccount` class. It has a field `accountNumber` (String) and `balance` (double). The `accountNumber` should be readable by anyone but not changeable after creation. The `balance` should only be modifiable through `deposit()` and `withdraw()` methods within the class. What access modifiers would you use for `accountNumber`, `balance`, `deposit()`, and `withdraw()`?
2. **Internal Framework Tool**: You are building a framework. You have a class `InternalLogger` that should only be usable by other classes within the same `com.myframework.logging` package. What modifier should you use for the `InternalLogger` class itself?
3. **Extensible Component**: You have a `Widget` class with a method `render()`. You want other developers to be able to create their own custom widgets by extending your class, and you want them to be able to call the original `render()` method using `super.render()`. What modifier should `render()` have?

### Quiz

1. What happens if you don't specify any access modifier for a class member?
2. Can a top-level Java class be declared as `private` or `protected`?
3. What is the main difference between `default` and `protected` access?
4. Why is it a good practice to declare most class fields as `private`?
5. If a method in a superclass is `public`, what access modifiers can an overriding method in a subclass have?

***

## Answers to Practice \& Quiz

### **Practice Answers**

1. **Banking System**:
    * `accountNumber`: `public final` (or `private` with a `public` getter) to make it readable but not changeable.
    * `balance`: `private`, to restrict direct access.
    * `deposit()` and `withdraw()`: `public`, so they can be called from anywhere to modify the balance in a controlled way.
2. **Internal Framework Tool**: The `InternalLogger` class should have **`default` (package-private)** access. You achieve this by not writing any modifier before `class InternalLogger`.
3. **Extensible Component**: The `render()` method should be **`protected`**. This allows subclasses, regardless of their package, to access it, while preventing classes that are not subclasses from calling it directly.

### **Quiz Answers**

1. If you don't specify an access modifier, the member is given **`default` (package-private)** access, meaning it is only visible to other classes in the same package.[^1]
2. No, a top-level class can only be `public` or `default`. Nested classes, however, can be `private` or `protected`.[^1]
3. `protected` provides the same package-level access as `default`, but **also allows subclasses in different packages** to access the member. `default` does not allow access from subclasses in different packages.[^1]
4. Declaring fields as `private` enforces **encapsulation**. It prevents external code from directly and uncontrollably modifying the object's internal state, which helps maintain data integrity and makes the class easier to maintain.
5. The overriding method must also be **`public`**. You cannot reduce the visibility of an overridden method in a subclass.[^1]

<div style="text-align: center">⁂</div>

[^1]: https://jenkov.com/tutorials/java/access-modifiers.html

[^2]: https://jenkov.com/tutorials/java/index.html

[^3]: https://jenkov.com/tutorials/java/fields.html

[^4]: https://jenkov.com/tutorials/java/methods.html

[^5]: https://jenkov.com/tutorials/java/constructors.html

[^6]: https://www.youtube.com/watch?v=J0WaMlWwgT4

[^7]: https://www.youtube.com/watch?v=ZV3pWdVvECo

[^8]: https://jenkov.com/tutorials/java/data-types.html

[^9]: https://www.scribd.com/document/36759390/JENKOV-Tutorial-on-Collections

[^10]: https://jenkov.com/tutorials/java/classes.html

