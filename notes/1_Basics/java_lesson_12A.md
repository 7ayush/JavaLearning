<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Give solutions also

Of course! Here are the complete solutions and explanations for the practice problems and quiz questions from the lesson on Java Conditional Statements.

***

## Answers to Practice \& Quiz on Java Conditionals

### **Practice Answers**

**1. Write a program that takes an integer variable `year` and prints whether it is a leap year or not.**

A year is a leap year if it is divisible by 4, except for end-of-century years, which must be divisible by 400. This logic can be implemented with nested `if` statements or a single complex boolean expression.

```java
public class LeapYearChecker {
    public static void main(String[] args) {
        int year = 2024; // You can change this value to test other years

        // A year is a leap year if it's divisible by 4 but not 100,
        // unless it's also divisible by 400.
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        // Test with other years:
        // 2000 -> Leap year (divisible by 400)
        // 1900 -> Not a leap year (divisible by 100 but not 400)
        // 2023 -> Not a leap year
    }
}
```

**2. Create a program that uses a `switch` statement to print the name of a month based on its number (1 for January, 2 for February, etc.).**

```java
public class MonthPrinter {
    public static void main(String[] args) {
        int monthNumber = 8; // Change this value to test
        String monthName;

        switch (monthNumber) {
            case 1:  monthName = "January";   break;
            case 2:  monthName = "February";  break;
            case 3:  monthName = "March";     break;
            case 4:  monthName = "April";     break;
            case 5:  monthName = "May";       break;
            case 6:  monthName = "June";      break;
            case 7:  monthName = "July";      break;
            case 8:  monthName = "August";    break;
            case 9:  monthName = "September"; break;
            case 10: monthName = "October";   break;
            case 11: monthName = "November";  break;
            case 12: monthName = "December";  break;
            default: monthName = "Invalid month number"; break;
        }

        System.out.println("The month is: " + monthName);
    }
}
```

**3. Use the ternary operator to find the larger of two numbers and store it in a variable.**

```java
public class TernaryExample {
    public static void main(String[] args) {
        int num1 = 25;
        int num2 = 18;

        // Use the ternary operator to assign the larger value to the 'largerNumber' variable
        int largerNumber = (num1 > num2) ? num1 : num2;

        System.out.println("The larger number is: " + largerNumber); // Output: The larger number is: 25
    }
}
```


***

### **Quiz Answers**

#### **1. What is the main purpose of the `else` statement?**
The main purpose of the `else` statement is to provide an **alternative block of code** that will be executed only when the condition in the preceding `if` (or `if-else-if`) statement evaluates to `false`. It provides a default path of execution.

#### **2. In a `switch` statement, what happens if you forget to add a `break` statement in a `case`?**
If you omit the `break` statement, a behavior called **"fall-through"** occurs. The program will execute the code for the matching `case` and then continue executing the code in all subsequent `case` blocks until it either hits a `break` statement or reaches the end of the `switch` block. This is sometimes done intentionally but is a common source of bugs for beginners.

#### **3. Can you use a `double` variable in a `switch` statement? Why or why not?**
No, you **cannot** use a `double` (or `float`) variable in a `switch` statement. The `switch` statement requires constant expressions of a specific set of discrete types: `byte`, `short`, `char`, `int`, their corresponding wrapper classes, `String`s, and `enum`s. Floating-point numbers are not allowed because their representation can lead to precision errors, making exact comparisons (`==`) unreliable.

#### **4. When is it more appropriate to use an `if-else-if` ladder instead of a `switch` statement?**
It is more appropriate to use an `if-else-if` ladder when:

#### * You need to check **ranges of values** (e.g., `score >= 90`).
* The conditions are **complex boolean expressions** involving logical operators like `&&` or `||` (e.g., `age > 18 && hasLicense`).
* The conditions involve **different variables**.

#### **5. What value must the expression inside an `if()` statement evaluate to?**
The expression inside an `if()` statement must evaluate to a **boolean** value, which is either `true` or `false`.

