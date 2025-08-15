# Java Basics – Lesson 3: Variables, Arrays, Operators, and Blocks

---

## ✅ Creating Variables and Naming Them

### Variable Naming Rules:
- Must begin with a **letter**, **$**, or **_**
- Cannot start with a digit
- Cannot use **Java reserved keywords** (e.g., `class`, `int`, `public`)
- Are **case-sensitive**

### Examples:
```java
int count = 5;
String $name = "Ayush";
double _price = 9.99;
```

---

## ✅ Primitive Type Variables

Java supports 8 primitive data types:

| Type      | Size     | Example             |
|-----------|----------|---------------------|
| `byte`    | 1 byte   | `byte b = 100;`     |
| `short`   | 2 bytes  | `short s = 1000;`   |
| `int`     | 4 bytes  | `int i = 5000;`     |
| `long`    | 8 bytes  | `long l = 100000L;` |
| `float`   | 4 bytes  | `float f = 5.6f;`   |
| `double`  | 8 bytes  | `double d = 10.5;`  |
| `boolean` | 1 bit    | `boolean flag = true;` |
| `char`    | 2 bytes  | `char c = 'A';`     |

---

## ✅ Creating Arrays

Arrays are used to store multiple values of the same type.

### Declaring and Initializing:
```java
int[] numbers = new int[5];       // Fixed size array
String[] names = { "Ayush", "Raj", "Maya" }; // Inline initialization
```

### Accessing elements:
```java
System.out.println(names[0]); // Outputs: Ayush
```

---

## ✅ The `var` Type Identifier (Java 10+)

- `var` tells Java to infer the type from the right-hand side.
- Cannot be used without initialization.

### Example:
```java
var count = 10;         // Inferred as int
var name = "Ayush";     // Inferred as String
```

---

## ✅ Using Operators in Java

Operators perform actions on variables and values.

### Arithmetic Operators:

| Operator | Description     | Example     |
|----------|-----------------|-------------|
| `+`      | Addition         | `a + b`     |
| `-`      | Subtraction      | `a - b`     |
| `*`      | Multiplication   | `a * b`     |
| `/`      | Division         | `a / b`     |
| `%`      | Modulo (remainder) | `a % b`  |

### Relational & Equality:

| Operator | Description     |
|----------|-----------------|
| `==`     | Equal to        |
| `!=`     | Not equal to    |
| `>`      | Greater than    |
| `<`      | Less than       |
| `>=`     | Greater or equal|
| `<=`     | Less or equal   |

### Logical Operators:

| Operator | Description |
|------|-------------|
| `&&` | Logical AND |
| `\|\|`     | Logical OR  |
| `!`  | Logical NOT |

---

## ✅ Expressions, Statements, and Blocks

- **Expression**: A piece of code that produces a value  
  e.g., `x + 1`, `name.equals("Ayush")`

- **Statement**: A complete instruction  
  e.g., `int a = 5;`, `System.out.println("Hi");`

- **Block**: A group of statements inside `{}`  
  Used in control flow, methods, classes, etc.

```java
{
    int x = 5;
    System.out.println(x);
}
```

---

## ✅ Control Flow Statements Overview

### Decision-making:
- `if`, `else if`, `else`
- `switch`

### Looping:
- `for`, `while`, `do-while`

### Branching:
- `break`, `continue`, `return`

---

## ✅ Switch Expressions (Java 14+)

Java's new switch syntax allows expressions.

```java
String result = switch (grade) {
    case "A" -> "Excellent";
    case "B" -> "Good";
    default -> "Needs Improvement";
};
System.out.println(result);
```

---

**Next Up**: Loops – `for`, `while`, `do-while` (Lesson 4)