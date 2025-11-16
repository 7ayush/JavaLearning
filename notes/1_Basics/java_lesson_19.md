<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Now lets discuss

[https://jenkov.com/tutorials/java/nested-classes.html](https://jenkov.com/tutorials/java/nested-classes.html)
[https://www.baeldung.com/java-nested-classes](https://www.baeldung.com/java-nested-classes)

Of course. Nested classes are a powerful feature in Java for logically grouping classes that are only used in one place, increasing encapsulation, and creating more readable and maintainable code.

This lesson, drawing from the excellent Jenkov and Baeldung tutorials, will provide a deep dive into the four types of nested classes in Java.

***

# A Deep Dive into Java Nested Classes

In Java, a **nested class** is simply a class that is defined inside another class. They are members of their enclosing class and can be a powerful tool for structuring your code.

**Why use nested classes?**

* **Logical Grouping**: If a class is only useful to one other class, it's logical to embed it within that class to keep related code together.
* **Increased Encapsulation**: A nested class has access to all members (including `private` ones) of its enclosing class. This allows for a tight coupling where needed, without exposing private members to the outside world.
* **Readability**: Placing small helper classes closer to where they are used can make the code easier to understand.

There are two main categories of nested classes, which are further subdivided:

1. **Static Nested Classes**
2. **Inner Classes** (Non-static Nested Classes)
    * Member Inner Classes
    * Local Classes
    * Anonymous Classes

## 1. Static Nested Classes

A `static` nested class is a class that is declared with the `static` modifier. It behaves much like a regular top-level class but is namespaced within its enclosing class.

**Key Characteristics:**

* It does **not** have access to the instance members (non-static fields and methods) of the outer class. It can only access `static` members.
* It does not need an instance of the outer class to be created.

**Syntax and Instantiation:**

```java
public class Outer {
    private static String OUTER_STATIC_FIELD = "Outer Static Field";

    public static class StaticNested {
        public void display() {
            // Can access static members of the outer class
            System.out.println(OUTER_STATIC_FIELD);
        }
    }
}

// To create an instance:
Outer.StaticNested nestedObject = new Outer.StaticNested();
nestedObject.display();
```

**Common Use Case**: The **Builder pattern** is a classic example where a `static` nested class is used to build an instance of the outer class.

## 2. Inner Classes (Non-static)

An inner class is a non-static nested class. The key difference is that an inner class is **associated with an instance** of its enclosing class. It holds an implicit reference to the outer class object that created it.

### A. Member Inner Classes

This is the most common type of inner class, declared at the same level as the outer class's fields and methods.

**Key Characteristics:**

* It **has full access** to all members (both `static` and non-static) of the outer class, including `private` ones.
* You must create an instance of the outer class first in order to create an instance of the inner class.

**Syntax and Instantiation:**

```java
public class Outer {
    private String outerInstanceField = "Outer Instance Field";

    public class Inner {
        public void display() {
            // Has access to the instance field of the outer class
            System.out.println(outerInstanceField);
        }
    }
}

// To create an instance:
Outer outerObject = new Outer();
Outer.Inner innerObject = outerObject.new Inner();
innerObject.display();
```


### B. Local Classes

A local class is a class defined **inside a method body**.

**Key Characteristics:**

* Its scope is limited to the method in which it is declared.
* It can access the members of the enclosing class, just like a member inner class.
* It can also access local variables of the method, but only if they are `final` or *effectively final* (meaning their value is never changed after initialization).

**Example:**

```java
public class Outer {
    public void processData() {
        final String message = "Data processed!";

        // Local class defined inside the method
        class LocalProcessor {
            public void showResult() {
                System.out.println(message); // Accesses method's local variable
            }
        }

        LocalProcessor processor = new LocalProcessor();
        processor.showResult();
    }
}
```


### C. Anonymous Classes

An anonymous class is a special type of local class that has **no name**. It is declared and instantiated in a single expression. They are typically used for one-time-use classes.

**Key Characteristics:**

* They are defined on-the-fly, usually to implement an interface or extend a class.
* They are concise but can make code harder to read if they become too complex.

**Example: Implementing an Interface**

```java
interface Greeting {
    void sayHello();
}

public class HelloWorld {
    public void greet() {
        // Anonymous class that implements the Greeting interface
        Greeting englishGreeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello!");
            }
        }; // Semicolon is required here

        englishGreeting.sayHello();
    }
}
```

This is very common for event listeners in GUI programming or for implementing `Runnable`.

***

## Summary: Static Nested vs. Inner Class

| Feature | Static Nested Class | Inner Class (Non-static) |
| :-- | :-- | :-- |
| **Association** | Tied to the outer **class**. | Tied to an **instance** of the outer class. |
| **Instantiation** | `new Outer.Nested()` | `outerInstance.new Inner()` |
| **Access** | Can only access `static` members of the outer class. | Can access all members (`static` and instance) of the outer class. |
| **Implicit Reference** | No | Yes, holds a reference to the outer class instance. |


***

## Practice \& Quiz

### Practice

1. **Builder Pattern**: Create a `Computer` class with several fields (`cpu`, `ram`, `storage`). Implement a `static` nested `Builder` class to construct a `Computer` object step-by-step.
2. **Iterator**: Create a `CustomList` class that holds an array of strings. Create a `private` inner class named `ListIterator` that implements the `java.util.Iterator` interface to iterate over the strings in `CustomList`.
3. **Event Listener**: Create a simple `Button` class with a `setOnClickListener()` method that accepts a custom `OnClickListener` interface. In your `main` method, use an anonymous class to define the click behavior.

### Quiz

1. What is the main difference between a `static` nested class and a non-static inner class?
2. How do you create an instance of a non-static member inner class?
3. Can a `static` nested class access a `private` non-static field of its outer class? Why or why not?
4. What does it mean for a local variable to be "effectively final" when used by a local or anonymous class?
5. What is a common use case for an anonymous class?

***

## Answers to Practice \& Quiz

### **Practice Answers**

**1. Builder Pattern**

```java
public class Computer {
    private final String cpu;
    private final int ram;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
    }

    public static class Builder {
        private String cpu;
        private int ram;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(int ram) {
            this.ram = ram;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
// Usage: Computer myPC = new Computer.Builder().setCPU("Intel i9").setRAM(32).build();
```

**2. Iterator**

```java
import java.util.Iterator;

public class CustomList implements Iterable<String> {
    private final String[] items;
    public CustomList(String... items) { this.items = items; }

    @Override
    public Iterator<String> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<String> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() { return currentIndex < items.length; }
        @Override
        public String next() { return items[currentIndex++]; }
    }
}
```

**3. Event Listener**

```java
interface OnClickListener { void onClick(); }

class Button {
    private OnClickListener listener;
    public void setOnClickListener(OnClickListener listener) { this.listener = listener; }
    public void click() { if (listener != null) listener.onClick(); }
}

public class Main {
    public static void main(String[] args) {
        Button myButton = new Button();
        myButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("Button was clicked!");
            }
        });
        myButton.click();
    }
}
```


### **Quiz Answers**

1. A `static` nested class is independent and not tied to an instance of the outer class. A non-static inner class holds an implicit reference to an instance of its outer class and can access its instance members.
2. You must first have an instance of the outer class. The syntax is `outerInstance.new InnerClass()`.
3. No. A `static` nested class is not associated with any instance of the outer class, so it cannot access non-static (instance) fields. It can only access `static` members.
4. It means the variable's value is never changed after it's initialized. This allows the local/anonymous class to safely "capture" its value.
5. A common use case is for implementing event handlers (like in GUIs) or creating a one-time implementation of an interface (like `Runnable` or `Comparator`).
<span style="display:none">[^1][^10][^11][^12][^13][^14][^15][^16][^17][^18][^19][^2][^20][^21][^22][^3][^4][^5][^6][^7][^8][^9]</span>

<div style="text-align: center">⁂</div>

[^1]: https://jenkov.com/tutorials/java/nested-classes.html

[^2]: https://www.baeldung.com/java-nested-classes

[^3]: https://www.geeksforgeeks.org/java/nested-classes-java/

[^4]: https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

[^5]: https://www.w3schools.com/java/java_inner_classes.asp

[^6]: https://www.scaler.com/topics/what-is-nested-class-in-java/

[^7]: https://dev.java/learn/classes-objects/nested-classes/

[^8]: https://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class

[^9]: https://www.w3schools.com/java/java_anonymous.asp

[^10]: https://www.programiz.com/java-programming/nested-inner-class

[^11]: https://www.geeksforgeeks.org/java/difference-between-static-and-non-static-nested-class-in-java/

[^12]: https://www.geeksforgeeks.org/java/anonymous-inner-class-java/

[^13]: https://www.baeldung.com/java-inner-classes-vs-subclasses

[^14]: https://www.baeldung.com/java-anonymous-classes

[^15]: https://javalaunchpad.com/nested-classes-in-java-a-comprehensive-guide/

[^16]: https://www.reddit.com/r/learnjava/comments/fuoh77/when_to_use_an_inner_static_class_vs_an_inner/

[^17]: https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html

[^18]: https://www.youtube.com/watch?v=UVOztdkD7WE

[^19]: https://www.programiz.com/java-programming/anonymous-class

[^20]: https://www.tutorialspoint.com/java/java_anonymous_class.htm

[^21]: https://jcoder.io/content/course/java/beginners/ch08/anonymous-classes

[^22]: https://www.tutorialspoint.com/java/java_innerclasses.htm

