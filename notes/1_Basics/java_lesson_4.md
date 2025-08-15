# Java Basics – Lesson 4: Control Flow and Branching

---

## ✅ Control Flow Statements Overview

Control flow in Java allows you to direct how your program executes.

### 🔹 Types of Control Flow:

1. **Decision-making statements**
    - `if`
    - `if-else`
    - `if else-if else`
    - `switch`

2. **Looping statements**
    - `for`
    - `while`
    - `do-while`

3. **Branching statements**
    - `break`
    - `continue`
    - `return`

---

## ✅ Decision-Making Statements

### 🔸 if-else Example:

```java
int age = 20;

if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```
### 🔸 if-else if-else:
```java
int score = 85;

if (score >= 90) {
    System.out.println("Grade A");
} else if (score >= 75) {
    System.out.println("Grade B");
} else {
    System.out.println("Grade C");
}
```
---
## ✅ Looping Statements
### 🔹 for loop
```java

for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}
```
### 🔹 while loop
```java
int j = 0;
while (j < 5) {
    System.out.println("j = " + j);
    j++;
}
```
### 🔹 do-while loop
```java
int k = 0;
do {
    System.out.println("k = " + k);
    k++;
} while (k < 5);
```
---

## ✅ Branching Statements
### 🔹 break
Exits the current loop or switch.

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
    System.out.println(i);
}
```
### 🔹 continue
Skips the current iteration.

```java
for (int i = 0; i < 5; i++) {
    if (i == 2) continue;
    System.out.println(i);
}
```
### 🔹 return
Exits from the current method.

```java
void greet(String name) {
    if (name == null) return;
    System.out.println("Hello " + name);
}
```

--- 
## ✅ Branching with switch Statement
Used as a clean way to replace multiple if-else-if.

### 🔸 Example:
```java
int day = 2;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Unknown day");
}
```
### 🔸 Notes:
break is needed to prevent fall-through.

default is optional but recommended.

--- 
## ✅ Switch Expressions (Java 14+)
A more concise and powerful form of switch.

### 🔸 Syntax:
```java
String result = switch (grade) {
    case "A" -> "Excellent";
    case "B" -> "Good";
    case "C" -> "Average";
    default -> "Fail";
};
System.out.println(result);
```
### 🔸 Multiple Labels:
```java
String message = switch (day) {
case 1, 2, 3, 4, 5 -> "Weekday";
case 6, 7 -> "Weekend";
default -> "Invalid day";
};
```
### 🔸 Using yield:
```java
int score = 85;

String grade = switch (score / 10) {
    case 10, 9 -> "A";
    case 8 -> "B";
    case 7 -> "C";
    default -> {
        System.out.println("Below Average");
        yield "D";
    }
};
```

