<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Type Casting
Java type casting is the process of converting a value from one data type to another. It is essential when you need to work with different data types in your code or when you want to store a value of one type into a variable of another type. There are two main types of type casting in Java:

### 1. Widening Type Casting (Implicit Casting)

- Converts a smaller data type to a larger data type.
- Happens automatically by the Java compiler.
- There is no risk of data loss.
- Example type order: byte → short → char → int → long → float → double.

**Example:**

```java
public class Main {
  public static void main(String[] args) {
    int myInt = 9;
    double myDouble = myInt; // Automatic casting: int to double

    System.out.println(myInt);     // Outputs 9
    System.out.println(myDouble);  // Outputs 9.0
  }
}
```


### 2. Narrowing Type Casting (Explicit Casting)

- Converts a larger data type to a smaller data type.
- Must be done manually by placing the target type in parentheses.
- There is a risk of data loss because the smaller type may not hold the entire value.
- Requires explicit syntax: `(targetType) value`.

**Example:**

```java
public class Main {
  public static void main(String[] args) {
    double myDouble = 9.78d;
    int myInt = (int) myDouble; // Manual casting: double to int

    System.out.println(myDouble); // Outputs 9.78
    System.out.println(myInt);    // Outputs 9
  }
}
```


### Why Type Casting is Important

- Prevents data loss by ensuring the right conversions.
- Enables operations between different data types.
- Helps manage memory efficiently.
- Converts user input (often strings) to numeric data for processing.
- Gives programmers better control over data types.


### Real-life Example: Calculating Percentage

```java
int maxScore = 500;
int userScore = 423;

// Cast userScore to float for accurate floating-point division
float percentage = (float) userScore / maxScore * 100.0f;

System.out.println("User's percentage is " + percentage);
```


### Summary

- **Widening casting** is automatic and safe.
- **Narrowing casting** is manual and can cause data loss.
- Use widening casting when you want to convert to a larger data type.
- Use narrowing casting when converting to a smaller data type but be cautious of precision loss.

Understanding and using Java type casting properly helps write flexible, robust, and efficient programs. If you want examples or further explanation on specific cases, let me know!

<div style="text-align: center">⁂</div>

[^1]: https://www.simplilearn.com/tutorials/java-tutorial/type-casting-in-java

[^2]: https://www.programiz.com/java-programming/typecasting

[^3]: https://www.w3schools.com/java/java_type_casting.asp

[^4]: https://www.geeksforgeeks.org/java/typecasting-in-java/

[^5]: https://www.geekster.in/articles/type-casting-java/

[^6]: https://herovired.com/learning-hub/topics/type-casting-in-java/

[^7]: https://prepbytes.com/blog/type-casting-in-java/

[^8]: https://www.tutorialspoint.com/java/java_type_casting.htm

[^9]: https://www.youtube.com/watch?v=H0LNjF9PSeM

[^10]: https://www.scaler.com/topics/java/type-casting-in-java/

