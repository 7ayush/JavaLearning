<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Conditionals in java

This is a core concept that allows your programs to make decisions and execute different blocks of code based on specific conditions.

***

# Java Conditional Statements: `if`, `else`, and `switch`

Conditional statements are the backbone of decision-making in programming. They allow a program to execute a certain section of code only if a particular test, or condition, evaluates to `true`. Java uses boolean values (`true` and `false`) to evaluate these conditions.[^1][^2][^3][^4]

Java provides several types of conditional statements:

* **`if` statement**: Executes a block of code if a condition is true.
* **`if-else` statement**: Executes one block of code if a condition is true, and another if it is false.
* **`if-else-if` ladder**: Tests a series of conditions in order.
* **`switch` statement**: Selects one of many code blocks to be executed based on the value of a variable.

***

## 1. The `if` Statement

The `if` statement is the most basic decision-making construct. It specifies that a block of code should be executed only if a condition is met.[^5][^6]

**Syntax:**

```java
if (condition) {
    // block of code to be executed if the condition is true
}
```

The `condition` must be a boolean expression—something that evaluates to either `true` or `false`.[^7]

**Example:**

```java
int score = 85;

if (score > 60) {
    System.out.println("Congratulations, you passed!");
}
```

In this example, since `85 > 60` is true, the message is printed. If `score` were 50, the `if` block would be skipped entirely.

***

## 2. The `if-else` Statement

The `if-else` statement provides an alternative path of execution for when the `if` condition is false.[^6]

**Syntax:**

```java
if (condition) {
    // executes this block if the condition is true
} else {
    // executes this block if the condition is false
}
```

**Example:**

```java
int number = 7;

if (number % 2 == 0) {
    System.out.println(number + " is an even number.");
} else {
    System.out.println(number + " is an odd number.");
}
```

Here, because `7 % 2 == 0` is false, the code inside the `else` block is executed.

***

## 3. The `if-else-if` Ladder

When you have multiple conditions to test, you can chain them together using an `if-else-if` ladder. The conditions are evaluated from top to bottom, and the first one that is `true` gets its code block executed. If none are true, the final `else` block runs.[^3]

**Syntax:**

```java
if (condition1) {
    // block for condition1
} else if (condition2) {
    // block for condition2
} else if (condition3) {
    // block for condition3
} else {
    // block if no other conditions are true
}
```

**Example: Assigning Grades**

```java
int score = 88;
char grade;

if (score >= 90) {
    grade = 'A';
} else if (score >= 80) {
    grade = 'B';
} else if (score >= 70) {
    grade = 'C';
} else {
    grade = 'F';
}

System.out.println("Your grade is: " + grade); // Prints: Your grade is: B
```


***

## 4. Nested `if` Statements

You can also place `if` statements inside other `if` statements. This is called nesting.[^3]

**Example:**

```java
int age = 25;
boolean hasLicense = true;

if (age >= 18) {
    System.out.println("You are old enough to drive.");
    if (hasLicense) {
        System.out.println("You are legally allowed to drive.");
    } else {
        System.out.println("You need to get a driver's license first.");
    }
} else {
    System.out.println("You are not old enough to drive.");
}
```


***

## 5. The Ternary Operator (`? :`)

The ternary operator is a compact, one-line shorthand for a simple `if-else` statement. It takes three operands.[^8]

**Syntax:**

```java
variable = (condition) ? valueIfTrue : valueIfFalse;
```

**Example:**

```java
int time = 20;
String result = (time < 18) ? "Good day." : "Good evening.";
System.out.println(result); // Prints: Good evening.
```

While concise, it's best used for simple assignments to avoid making code difficult to read.[^2]

***

## 6. The `switch` Statement

A `switch` statement is a clean alternative to a long `if-else-if` ladder when you are comparing a single variable against a list of discrete, constant values.[^9][^10]

**Syntax:**

```java
switch (expression) {
    case value1:
        // code block
        break;
    case value2:
        // code block
        break;
    // ... other cases
    default:
        // code block if no case matches
}
```

**How it works:**

* The `switch` expression is evaluated once.[^9]
* Its value is compared with the value of each `case`.
* If a match is found, the corresponding block of code is executed.
* The `break` statement is crucial. It exits the `switch` block. If `break` is omitted, execution "falls through" to the next `case` block.
* The `default` block is optional and runs if no other `case` matches.[^9]

**Example:**

```java
int day = 4;
String dayName;

switch (day) {
    case 1: dayName = "Monday"; break;
    case 2: dayName = "Tuesday"; break;
    case 3: dayName = "Wednesday"; break;
    case 4: dayName = "Thursday"; break;
    case 5: dayName = "Friday"; break;
    case 6: dayName = "Saturday"; break;
    case 7: dayName = "Sunday"; break;
    default: dayName = "Invalid day"; break;
}

System.out.println(dayName); // Prints: Thursday
```


***

## 7. `if-else-if` vs. `switch`

| Feature | `if-else-if` | `switch` |
| :-- | :-- | :-- |
| **Condition Type** | Can evaluate complex boolean expressions (e.g., `x > 10 && y < 5`). | Compares a single variable/expression against constant values (`int`, `char`, `String`, `enum`). |
| **Comparison** | Better for checking ranges of values (e.g., score >= 90)[^11]. | Better for a fixed number of discrete values (e.g., day == 1, 2, 3...)[^12]. |
| **Readability** | Can become hard to read if there are many conditions. | Often cleaner and more readable for multi-way branching. |
| **Data Types** | Works with any expression that results in a boolean. | Limited to byte, short, char, int, `String`, and enums. |


***

## 8. Practice \& Quiz

### Practice

1. Write a program that takes an integer variable `year` and prints whether it is a leap year or not. (A leap year is divisible by 4, but not by 100 unless it is also divisible by 400).
2. Create a program that uses a `switch` statement to print the name of a month based on its number (1 for January, 2 for February, etc.). Include a `default` case for invalid numbers.
3. Use the ternary operator to find the larger of two numbers and store it in a variable.

### Quiz

1. What is the main purpose of the `else` statement?
2. In a `switch` statement, what happens if you forget to add a `break` statement in a `case`?
3. Can you use a `double` variable in a `switch` statement? Why or why not?
4. When is it more appropriate to use an `if-else-if` ladder instead of a `switch` statement?
5. What value must the expression inside an `if()` statement evaluate to?

<div style="text-align: center">⁂</div>

[^1]: https://www.w3schools.com/java/java_conditions.asp

[^2]: https://www.learnjavaonline.org/en/Conditionals

[^3]: https://www.linkedin.com/pulse/day-4-conditional-statements-poojaashree-p-v-qil0c

[^4]: https://java-programming.mooc.fi/part-1/6-conditional-statements/

[^5]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html

[^6]: https://www.geeksforgeeks.org/java/decision-making-javaif-else-switch-break-continue-jump/

[^7]: https://www.digitalocean.com/community/tutorials/how-to-write-conditional-statements-in-java

[^8]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html

[^9]: https://www.w3schools.com/java/java_switch.asp

[^10]: https://www.koderhq.com/tutorial/java/conditional-control/

[^11]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html

[^12]: https://www.baeldung.com/cs/if-else-switch

[^13]: https://www.youtube.com/watch?v=lGHzXsEoUkM

[^14]: https://www.scholarhat.com/tutorial/java/java-conditional-statements-if-else-switch

[^15]: https://stackoverflow.com/questions/13060807/switch-with-if-else-if-else-and-loops-inside-case

[^16]: https://www.w3resource.com/java-exercises/conditional-statement/index.php

[^17]: https://www.codecademy.com/learn/learn-java/modules/learn-java-conditionals-control-flow-u/cheatsheet

[^18]: https://www.geeksforgeeks.org/java/switch-statement-in-java/

[^19]: https://www.shiksha.com/online-courses/articles/conditional-statements-in-java/

[^20]: https://www.youtube.com/watch?v=OTMsKM8OZNQ

