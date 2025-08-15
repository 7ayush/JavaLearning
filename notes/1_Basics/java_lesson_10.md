<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Now teach me Java math. Refer this

https://jenkov.com/tutorials/java/math-operators-and-math-class.html

Make sure your answer is complete.

Of course. Here is a comprehensive guide to performing mathematical operations in Java, covering both the fundamental math operators and the powerful `java.lang.Math` class.

### Java Math Operators

Java includes a set of built-in operators for basic arithmetic.[^1][^2]


| Operator | Description | Example | Result |
| :-- | :-- | :-- | :-- |
| `+` | Addition | `int sum = 10 + 5;` | `15` |
| `-` | Subtraction | `int diff = 10 - 5;` | `5` |
| `*` | Multiplication | `int prod = 10 * 5;` | `50` |
| `/` | Division | `int div = 10 / 5;` | `2` |
| `%` | Modulo (Remainder) | `int rem = 10 % 3;` | `1`[^3] |

#### Compound Assignment Operators

For convenience, Java provides compound operators that combine an arithmetic operation with an assignment.[^3]

* `+=` (Addition assignment)
* `-=` (Subtraction assignment)
* `*=` (Multiplication assignment)
* `/=` (Division assignment)
* `%=` (Remainder assignment)

**Example:**

```java
int result = 10;
result += 5; // Equivalent to result = result + 5;
System.out.println(result); // Prints 15
```


#### Operator Precedence

In expressions with multiple operators, `*`, `/`, and `%` have higher precedence than `+` and `-`, meaning they are evaluated first. You can use parentheses `()` to control the order of evaluation, as expressions inside parentheses are always evaluated first.[^3]

**Example:**

```java
int result1 = 10 + 5 * 2;   // Evaluates 5 * 2 first, result is 20
int result2 = (10 + 5) * 2; // Evaluates 10 + 5 first, result is 30
```


### Integer vs. Floating-Point Math

The behavior of division changes based on the data types involved.[^3]

* **Integer Math**: When dividing two integers, the result is also an integer, and any fractional part is truncated (cut off).[^3]
* **Floating-Point Math**: To get a precise result with decimals, at least one of the numbers in the division must be a floating-point type (`float` or `double`). You can force a number to be treated as a double by appending a `D`.[^3]

**Example:**

```java
// Integer division
int intResult = 10 / 4; // Result is 2 (the .5 is truncated)

// Floating-point division
double doubleResult = 10.0 / 4; // Result is 2.5
double doubleResult2 = 10D / 4D; // Result is 2.5
```


### The `java.lang.Math` Class

For more complex calculations, Java provides the `Math` class, which contains a collection of static methods for advanced numeric operations. Since all its methods are static, you don't need to create an object of the `Math` class; you can call the methods directly using the class name.[^4][^5][^3]

#### Basic Math Functions

* **`Math.abs(x)`**: Returns the absolute (positive) value of a number.[^6][^3]
* **`Math.max(x, y)`**: Returns the greater of two numbers.[^7][^3]
* **`Math.min(x, y)`**: Returns the smaller of two numbers.[^3]
* **`Math.round(x)`**: Rounds a floating-point number to the nearest integer.[^3]
* **`Math.ceil(x)`**: Rounds a floating-point number *up* to the nearest integer.[^3]
* **`Math.floor(x)`**: Rounds a floating-point number *down* to the nearest integer.[^3]
* **`Math.random()`**: Returns a random `double` between 0.0 (inclusive) and 1.0 (exclusive).[^3]
* * **`Math.floorDiv()`**: Returns lower value incase of incomplete division of a number.[^3]

**Example:**

```java
System.out.println(Math.max(5, 10));      // 10
System.out.println(Math.abs(-4.7));       // 4.7
System.out.println(Math.round(9.55));   // 10
System.out.println(Math.ceil(7.1));       // 8.0
System.out.println(Math.floor(7.9));      // 7.0
System.out.println(Math.floorDiv(-100,9));   // -12
System.out.println(Math.random()*1000;   // anything can come from 0 to 1000
```


#### Exponential and Logarithmic Functions

* **`Math.pow(a, b)`**: Returns the value of `a` raised to the power of `b`.[^6][^3]
* **`Math.sqrt(x)`**: Returns the square root of `x`.[^6][^3]
* **`Math.exp(x)`**: Returns Euler's number *e* raised to the power of `x`.[^3]
* **`Math.log(x)`**: Returns the natural logarithm (base *e*) of `x`.[^6][^3]
* **`Math.log10(x)`**: Returns the base 10 logarithm of `x`.[^3]

**Example:**

```java
System.out.println(Math.pow(2, 3));   // 8.0 (2 to the power of 3)
System.out.println(Math.sqrt(64));    // 8.0
```


#### Trigonometric Functions

The `Math` class includes a comprehensive set of trigonometric functions. These methods operate on angles expressed in **radians**.[^3]

* **`Math.PI`**: A `double` constant that is the closest value to pi.[^6][^3]
* **`Math.sin(a)`**: Computes the sine of angle `a`.[^3]
* **`Math.cos(a)`**: Computes the cosine of angle `a`.[^3]
* **`Math.tan(a)`**: Computes the tangent of angle `a`.[^3]
* **`Math.toDegrees(a)`**: Converts an angle from radians to degrees.[^6][^3]
* **`Math.toRadians(a)`**: Converts an angle from degrees to radians.[^6][^3]
* **`Math.atan2(a)`**: ""Returns the angle theta from the conversion of rectangular coordinates (x, y) to polar coordinates (r, theta)".".  [^3]
* **`Math.sinh(a)`**: Calculates the hyperbolic sine value of a value between 1 and -1
* **`Math.cosh(a)`**: Calculates the hyperbolic cos value of a value between 1 and -1
* **`Math.tanh(a)`**: Calculates the hyperbolic tan value of a value between 1 and -1
**Example:**

```java
// Calculate the sine of 90 degrees
double angleDegrees = 90;
double angleRadians = Math.toRadians(angleDegrees);
double sineValue = Math.sin(angleRadians);

System.out.println("Sine of 90 degrees is " + sineValue); // Prints 1.0
```

<div style="text-align: center">⁂</div>

[^1]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html

[^2]: https://www.geeksforgeeks.org/java/java-arithmetic-operators-with-examples/

[^3]: https://jenkov.com/tutorials/java/math-operators-and-math-class.html

[^4]: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html

[^5]: https://www.geeksforgeeks.org/java/java-math-class/

[^6]: https://www.tutorialspoint.com/java/java_lang_math.htm

[^7]: https://www.w3schools.com/java/java_math.asp

[^8]: https://www.w3schools.com/java/java_operators.asp

[^9]: https://www.tutorialspoint.com/java/java_basic_operators.htm

[^10]: https://www.dremendo.com/java-programming-tutorial/java-mathematical-functions

[^11]: https://www.programiz.com/java-programming/operators

[^12]: https://www.baeldung.com/java-lang-math

[^13]: https://www.iitk.ac.in/esc101/05Aug/tutorial/java/nutsandbolts/arithmetic.html

[^14]: https://www.programiz.com/java-programming/library/math

[^15]: https://www.geeksforgeeks.org/java/operators-in-java/

[^16]: https://www.geekster.in/articles/math-class-in-java/

[^17]: https://www.w3schools.com/java/java_ref_math.asp

[^18]: https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Math.html

[^19]: https://www.youtube.com/watch?v=w0VTlSOXBs8

[^20]: https://learn.microsoft.com/en-us/dotnet/api/java.lang.math?view=net-android-35.0

