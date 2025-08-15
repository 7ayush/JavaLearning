# Java Basics – Lesson 1: Setup & Data Types

## ✅ Part 1: Setting Up Java Locally

### 1. Install Java JDK
- Go to [https://jdk.java.net](https://jdk.java.net)
- Download the latest **LTS version** (e.g., Java 17 or 21)
- Install it and verify installation:
  ```bash
  java -version
  ```

### 2. Install IntelliJ IDEA
- Download from [https://www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download)
- Choose the **Community Edition**
- Create a new project and set the Project SDK to the JDK you installed

### 3. Create Your First Java File
- File name: `HelloWorld.java`
- Contents:
  ```java
  public class HelloWorld {
      public static void main(String[] args) {
          System.out.println("Hello, Ayush!");
      }
  }
  ```

---

## ✅ Part 2: Java Syntax – Variables & Data Types

### 🧱 Java is statically typed

Every variable must be declared with a type.

### 🧪 Basic Data Types

| Type     | Meaning              | Example              |
|----------|----------------------|----------------------|
| `int`    | Integer numbers      | `int age = 24;`      |
| `double` | Decimal numbers      | `double pi = 3.14;`  |
| `boolean`| True/false values    | `boolean isValid = true;` |
| `char`   | Single character     | `char grade = 'A';`  |
| `String` | Sequence of chars    | `String name = "Ayush";` |

### ✨ Type Promotion

```java
int x = 7;
double y = 2.0;
System.out.println(x + y);  // Outputs 9.0
```

`int` is promoted to `double`, and the result is a `double`.

---

## 🧠 Trivia Recap

1. `int / int` results in **integer division**
2. Variable names:
   - ✅ Can start with `_` or a letter
   - ❌ Cannot start with a number or use `-`
   - ❌ Cannot use Java reserved keywords like `class`

---

## ✅ Output Examples

```java
System.out.println(7 / 2);     // Outputs 3 (int division)
System.out.println(7 / 2.0);   // Outputs 3.5 (double division)
```

---

## ✅ Mini Exercise

Try creating this Java class and running it in IntelliJ:

```java
public class DataTypesDemo {
    public static void main(String[] args) {
        int age = 24;
        double score = 88.5;
        char initial = 'A';
        boolean isJavaFun = true;
        String name = "Ayush";

        System.out.println(name + " | " + age + " | " + score + " | " + initial + " | " + isJavaFun);
    }
}
```

---

**Next Up**: Control Flow – `if`, `else`, and `switch`