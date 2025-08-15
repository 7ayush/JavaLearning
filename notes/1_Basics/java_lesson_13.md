<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Loops in Java
 Loops are a fundamental concept in programming, allowing you to execute a block of code repeatedly. This lesson will provide an in-depth guide to all the looping constructs available in Java.

Here is your comprehensive lesson on Java Loops.

***

# A Deep Dive into Java Loops

In Java, loops are used to repeat a block of code as long as a certain condition is met. They save time, reduce errors, and make code more readable and efficient. Java provides three primary types of loops: the `for` loop, the `while` loop, and the `do-while` loop, along with an enhanced version of the `for` loop called the `for-each` loop.[^1][^2][^3]

## 1. The `for` Loop

The `for` loop is ideal when you know exactly how many times you want to execute a block of code. It's an entry-controlled loop, meaning it checks the condition *before* executing the loop's body.[^4][^5]

### Syntax and Components

The `for` loop has a concise and structured syntax with three essential parts separated by semicolons.[^6][^5]

**Syntax:**

```java
for (initialization; condition; update) {
    // block of code to be executed
}
```

* **Initialization**: Executed once at the very beginning of the loop. It's used to declare and initialize a loop control variable (e.g., `int i = 0`).[^5]
* **Condition**: A boolean expression evaluated before each iteration. If it's `true`, the loop body executes. If it's `false`, the loop terminates.[^5]
* **Update**: Executed at the end of each iteration. It's typically used to increment or decrement the loop control variable (e.g., `i++`).[^4]


### How it Works

1. The `initialization` statement runs once.
2. The `condition` is evaluated.
3. If the condition is `true`, the code inside the loop's body is executed.
4. The `update` statement is executed.
5. Control returns to step 2, and the process repeats until the condition becomes `false`.[^5]

**Example: Printing numbers from 1 to 5**

```java
class ForLoopExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }
    }
}
```

**Output:**

```
Iteration: 1
Iteration: 2
Iteration: 3
Iteration: 4
Iteration: 5
```


## 2. The `while` Loop

The `while` loop is used to repeat a block of code as long as a specified condition is true. It's also an entry-controlled loop, so if the condition is false initially, the loop will never execute.[^3][^7]

### Syntax

```java
while (condition) {
    // block of code to be executed
    // statement to update the loop variable must be here!
}
```

**Key Point**: It is crucial to include a statement within the `while` loop that eventually makes the condition false. Otherwise, you will create an infinite loop.[^3]

**Example: Countdown**

```java
class WhileLoopExample {
    public static void main(String[] args) {
        int countdown = 3;

        while (countdown > 0) {
            System.out.println(countdown);
            countdown--; // Decrement the counter
        }
        System.out.println("Happy New Year!");
    }
}
```

**Output:**

```
3
2
1
Happy New Year!
```


## 3. The `do-while` Loop

The `do-while` loop is a variant of the `while` loop. Its key feature is that it's an **exit-controlled loop**, which means it checks the condition *after* executing the loop body. This guarantees that the block of code is executed **at least once**, even if the condition is false from the start.[^8][^9][^10]

### Syntax

```java
do {
    // block of code to be executed
} while (condition);
```

**Note**: A semicolon is required after the `while(condition)` part.[^8]

**Example: Guaranteed Execution**

```java
class DoWhileExample {
    public static void main(String[] args) {
        int i = 10;

        do {
            System.out.println("This will run at least once. i = " + i);
            i++;
        } while (i < 5); // This condition is initially false
    }
}
```

**Output:**

```
This will run at least once. i = 10
```


## 4. The `for-each` (Enhanced `for`) Loop

Introduced in Java 5, the `for-each` loop provides a cleaner, more readable syntax for iterating through all elements of an **array** or a **collection**. It is often called the enhanced for loop.[^11][^12][^13]

### Syntax

```java
for (dataType item : arrayOrCollection) {
    // block of code to be executed for each item
}
```

* `dataType`: The data type of the elements in the array/collection.
* `item`: A variable that will hold the current element in each iteration.
* `arrayOrCollection`: The array or collection to iterate over.[^11]

**Example: Iterating Through an Array**

```java
class ForEachExample {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 5, -5};

        System.out.println("The elements are:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
```

**Output:**

```
The elements are:
3
7
5
-5
```


### When to Use `for-each`

Use the `for-each` loop when you need to access every element of a collection from start to finish and you **do not need to know the index** of the element. Avoid it if you need to modify the array or iterate in a custom order (e.g., backward).[^12][^14]

***

## 5. Summary and Comparison

| Feature | `for` Loop | `while` Loop | `do-while` Loop | `for-each` Loop |
| :-- | :-- | :-- | :-- | :-- |
| **Best For** | When the number of iterations is known. | When the number of iterations is unknown and depends on a condition. | When the loop must execute at least once. | Iterating over all elements of an array or collection. |
| **Control Type** | Entry-Controlled | Entry-Controlled | Exit-Controlled | N/A |
| **Syntax** | `for(init; cond; update)` | `while(cond)` | `do { } while(cond);` | `for(type var : collection)` |
| **Guaranteed Run?** | No | No | **Yes, at least once** | No (if collection is empty) |


***

## 6. Loop Control Statements: `break`, `continue`, and Labels

Java provides branching statements that allow you to alter the normal flow of a loop's execution. The two main statements for this are `break` and `continue`.

### A. The `break` Statement

The `break` statement is used to **terminate the loop immediately**. When `break` is encountered inside a loop, the loop is exited, and the program control resumes at the next statement following the loop.

**Use Case**: You want to stop searching once you've found what you're looking for, or exit a loop based on a specific condition that isn't the main loop condition.

**Example: Finding the first occurrence of a number**

```java
class BreakExample {
    public static void main(String[] args) {
        int[] numbers = {10, 25, 42, 88, 15, 99};
        int numberToFind = 88;
        boolean found = false;

        for (int number : numbers) {
            System.out.println("Checking: " + number);
            if (number == numberToFind) {
                found = true;
                break; // Exit the loop immediately
            }
        }

        if (found) {
            System.out.println("Number " + numberToFind + " found!");
        } else {
            System.out.println("Number not found.");
        }
    }
}
```

**Output:**

```
Checking: 10
Checking: 25
Checking: 42
Checking: 88
Number 88 found!
```

Notice how the loop stopped at `88` and didn't check `15` or `99`.

### B. The `continue` Statement

The `continue` statement is used to **skip the current iteration** of a loop and move to the next one. Any code inside the loop following the `continue` statement is skipped for that iteration.

**Use Case**: You want to ignore certain values or conditions but continue with the rest of the loop's iterations.

**Example: Printing only odd numbers**

```java
class ContinueExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            // If the number is even, skip this iteration
            if (i % 2 == 0) {
                continue; // Go to the next iteration (i++)
            }
            // This line is only reached for odd numbers
            System.out.print(i + " ");
        }
    }
}
```

**Output:**

```
1 3 5 7 9
```


### C. Labeled `break` and `continue`

When working with **nested loops**, the standard `break` and `continue` statements only affect the **innermost loop**. To control an outer loop from within an inner one, you can use **labels**. A label is simply a valid Java identifier followed by a colon (`:`).

**Labeled `break`**: Terminates the labeled loop.

**Example: Using a labeled `break` to exit a nested loop**

```java
class LabeledBreakExample {
    public static void main(String[] args) {
        outerLoop: // This is a label
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.println("i = " + i + ", j = " + j);
                if (i == 2 && j == 2) {
                    System.out.println("Breaking out of the outer loop!");
                    break outerLoop; // Exits the loop labeled 'outerLoop'
                }
            }
        }
        System.out.println("End of program.");
    }
}
```

**Output:**

```
i = 1, j = 1
i = 1, j = 2
i = 1, j = 3
i = 2, j = 1
i = 2, j = 2
Breaking out of the outer loop!
End of program.
```

Without the label, `break` would have only exited the inner `j` loop, and the outer `i` loop would have continued with `i = 3`.

**Labeled `continue`**: Skips the current iteration of the labeled (outer) loop.

### D. The `return` Statement

While not strictly a loop control statement, the `return` statement can also be used to exit a loop. When a `return` is executed inside a loop, it not only terminates the loop but also **exits the entire method**.

***

### Updated Practice \& Quiz

I'll add these concepts to the practice and quiz questions from the previous lesson.

### Practice

1. Write a program using a `for` loop to calculate the factorial of a number.
2. Create a guessing game with a `while` loop (as before).
3. Use a `do-while` loop for a simple menu.
4. **New:** Write a program that loops from 1 to 50.
    * Use `continue` to skip any number divisible by 5.
    * Use `break` to exit the loop entirely if the number is greater than 40.
    * Print all other numbers.

### Quiz

1. What are the three components in the parentheses of a standard `for` loop?
2. What is the primary difference between a `while` and a `do-while` loop?
3. Can you use a `for-each` loop to iterate backward?
4. What happens if you forget the update statement in a `while` loop?
5. Which loop is best for iterating through an `ArrayList` when you don't need the index?
6. **New:** What is the difference between `break` and `continue`?
7. **New:** In what scenario would you need to use a labeled `break`?
