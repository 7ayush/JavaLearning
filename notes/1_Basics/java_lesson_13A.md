<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Now give quiz solutions

Of course. Here are the complete solutions for the practice problems and quiz questions from the comprehensive lesson on Java Loops.

***

## Answers to Practice \& Quiz on Java Loops

### **Practice Answers**

**1. Write a program using a `for` loop to calculate the factorial of a number.**

```java
public class FactorialCalculator {
    public static void main(String[] args) {
        int number = 5; // The number to calculate the factorial of
        long factorial = 1; // Use long to avoid overflow for larger numbers

        // Factorial of 0 is 1. For numbers > 0, multiply from number down to 1.
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            for (int i = 1; i <= number; i++) {
                factorial = factorial * i;
            }
            System.out.println("The factorial of " + number + " is: " + factorial);
        }
    }
}
```

**2. Create a guessing game using a `while` loop.**

```java
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int userGuess = 0;

        System.out.println("Guess a number between 1 and 100:");

        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            }
        }

        System.out.println("Congratulations! You guessed the number: " + numberToGuess);
        scanner.close();
    }
}
```

**3. Use a `do-while` loop for a simple menu-driven program.**

```java
import java.util.Scanner;

public class MenuExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Displaying user profile...");
                    break;
                case 2:
                    System.out.println("Opening profile editor...");
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
```

**4. Write a program that loops from 1 to 50, using `continue` to skip multiples of 5 and `break` to exit if the number exceeds 40.**

```java
public class LoopControlPractice {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            // Exit the loop if the number is greater than 40
            if (i > 40) {
                break;
            }
            
            // Skip the current iteration if the number is divisible by 5
            if (i % 5 == 0) {
                continue;
            }

            System.out.print(i + " ");
        }
        System.out.println("\nLoop terminated.");
    }
}
```

**Output:**

```
1 2 3 4 6 7 8 9 11 12 13 14 16 17 18 19 21 22 23 24 26 27 28 29 31 32 33 34 36 37 38 39 
Loop terminated.
```


***

### **Quiz Answers**

#### **1. What are the three components in the parentheses of a standard `for` loop?**
The three components are:

* **Initialization**: A statement executed once before the loop starts (e.g., `int i = 0`).
* **Condition**: A boolean expression checked before each iteration. The loop continues as long as it's true.
* **Update**: A statement executed at the end of each iteration (e.g., `i++`).

#### **2. What is the primary difference between a `while` loop and a `do-while` loop?**
A `do-while` loop is an **exit-controlled** loop, meaning its condition is checked *after* the loop body executes. This guarantees the loop body will run **at least once**. A `while` loop is **entry-controlled** and checks the condition *before* executing, so it may not run at all if the condition is initially false.

#### **3. Can you use a `for-each` loop to iterate backward through an array? Why or why not?**
No, you cannot. The `for-each` loop is designed for simple, forward iteration from the first element to the last. It abstracts away the index and does not provide any mechanism to control the direction of iteration.

#### **4. What happens if you forget the update statement (like `i++`) in a `while` loop that relies on it?**
This will almost certainly create an **infinite loop**. If the condition depends on a variable that is never updated, the condition will never evaluate to `false`, causing the loop to run forever.

#### **5. Which type of loop is most suitable for iterating through all the items in an `ArrayList` when you don't need the index?**
The **`for-each` loop** (or enhanced for loop) is the most suitable. Its syntax is clean, concise, and less error-prone for this specific task.

#### **6. What is the difference between `break` and `continue`?**

* **`break`**: Immediately **terminates** the entire innermost loop it is in.
* **`continue`**: Skips the remainder of the current iteration and proceeds directly to the **next iteration** of the loop.

#### **7. In what scenario would you need to use a labeled `break`?**
You would use a labeled `break` when you are inside a **nested loop** and need to terminate one of the **outer loops**, not just the innermost one where the `break` statement is located.

