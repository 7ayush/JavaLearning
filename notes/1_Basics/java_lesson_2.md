# Java Basics – Lesson 2: Control Flow & Logic

## ✅ Part 1: `if`, `else if`, `else`

Java makes decisions using conditional statements.

### 🔹 Syntax

```java
int score = 85;

if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 75) {
    System.out.println("Grade: B");
} else {
    System.out.println("Grade: C or below");
}
```

- Only the **first true condition** is executed.
- You can chain as many `else if` blocks as needed.

---

## ✅ Part 2: Logical Operators

Used to combine conditions.

| Operator     | Meaning          | Example                      |
|--------------|------------------|------------------------------|
| `&&`         | AND              | `x > 5 && y < 10`            |
| `\|      \|` | OR               | `x > 5 \|\| y < 10` |
| `!`          | NOT (negation)   | `!isReady`                   |

### Example:

```java
int age = 22;
boolean hasID = true;

if (age >= 18 && hasID) {
    System.out.println("Entry allowed");
} else {
    System.out.println("Access denied");
}
```

---

## ✅ Part 3: `switch` Statements

Useful for checking a variable against multiple values.

### 🔹 Basic Syntax:

```java
int day = 3;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Some other day");
}
```

### 🔹 Arrow Syntax (Java 14+):

```java
String grade = "A";

switch (grade) {
    case "A" -> System.out.println("Excellent");
    case "B" -> System.out.println("Good");
    default -> System.out.println("Needs improvement");
}
```

---

## ✅ Part 4: Operator Precedence

Java evaluates logical operators in this order:

1. `!` (NOT)
2. `&&` (AND)
3. `||` (OR)

### Example:

```java
int x = 10;
int y = 20;

if (x > 5 || y < 10 && x == 10) {
    System.out.println("Condition met");
}
```

This runs because:
- `y < 10 && x == 10` → false
- `x > 5` → true
- `true || false` → true

---

## 🧠 Practice Questions

1. What will this print?
   ```java
   int number = 7;

   if (number > 5) {
       System.out.println("Greater than 5");
   } else if (number > 3) {
       System.out.println("Greater than 3");
   } else {
       System.out.println("3 or less");
   }
   ```

2. Predict the output:
   ```java
   int temp = 30;

   if (temp < 0) {
       System.out.println("Freezing");
   } else if (temp < 20) {
       System.out.println("Cold");
   } else if (temp < 35) {
       System.out.println("Warm");
   } else {
       System.out.println("Hot");
   }
   ```

---

**Next Up**: Loops – `for`, `while`, `do-while`