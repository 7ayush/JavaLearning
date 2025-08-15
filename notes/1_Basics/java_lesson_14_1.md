<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Answers to Practice \& Quiz on Java OOP Basics

### **Practice Answers**

Here is the complete, runnable code for the `Book` class and a `Main` class to test it, as described in the practice exercises.

**`Book.java` file:**

```java
public class Book {
    // 1. Fields for title, author, and pageCount
    String title;
    String author;
    int pageCount;

    // 2. Constructor to initialize all three fields
    public Book(String title, String author, int pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    // 3. Method to print a summary of the book
    public void getSummary() {
        System.out.println("Title: " + this.title + ", Author: " + this.author + ", Pages: " + this.pageCount);
    }
}
```

**`Library.java` file (or any `main` class):**

```java
public class Library {
    public static void main(String[] args) {
        // 4. Create two different Book objects
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 310);
        Book book2 = new Book("Dune", "Frank Herbert", 412);

        // Call the getSummary() method on both objects
        System.out.println("Details for the first book:");
        book1.getSummary();

        System.out.println("\nDetails for the second book:");
        book2.getSummary();
    }
}
```

**Output of the program:**

```
Details for the first book:
Title: The Hobbit, Author: J.R.R. Tolkien, Pages: 310

Details for the second book:
Title: Dune, Author: Frank Herbert, Pages: 412
```


***

### **Quiz Answers**

#### **1. What is the main difference between a class and an object?**
A **class** is a blueprint or template that defines properties and behaviors. An **object** is a specific instance created from that class blueprint, with its own set of data for the fields defined in the class.

#### **2. What is the keyword used to create an object from a class?**
The `new` keyword is used to instantiate (create) an object.

#### **3. What is the primary purpose of a constructor?**
The primary purpose of a constructor is to **initialize the state** of a newly created object. It sets the initial values for the object's fields.

#### **4. If a class is named `Student`, what must its constructor be named?**
The constructor must have the **exact same name** as the class, so it must be named `Student`.

#### **5. How do you access a field or method of an object?**
You use **dot notation (`.`)**. For example: `myObject.fieldName` to access a field or `myObject.methodName()` to call a method.

