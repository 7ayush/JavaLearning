<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Java Data Types: Primitive vs Non-Primitive

Understanding data types is **foundational to mastering Java**. Data types determine:

- **What kind of data** a variable can store,
- **How much memory** is allocated, and
- **What operations** are allowed.

Java data types are divided into two broad categories:

- **Primitive Data Types**
- **Non-Primitive (Reference) Data Types**


## 1. Primitive Data Types

**Primitive data types** are the most basic data types built into the Java language. They represent simple, indivisible values—not objects. There are **eight** primitive types:


| Data Type | Size | Example Value | Range / Description | Default Value |
| :-- | :-- | :-- | :-- | :-- |
| `byte` | 1 byte | 5 | -128 to 127 | 0 |
| `short` | 2 bytes | 300 | -32,768 to 32,767 | 0 |
| `int` | 4 bytes | 12345 | -2,147,483,648 to 2,147,483,647 | 0 |
| `long` | 8 bytes | 12345678900L | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 | 0L |
| `float` | 4 bytes | 3.14f | 6-7 decimal digits | 0.0f |
| `double` | 8 bytes | 3.1415926535 | 15-16 decimal digits | 0.0d |
| `char` | 2 bytes | 'A' | 0 to 65,535 (Unicode) | '\u0000' |
| `boolean` | ~1 bit* | true, false | true or false | false |

*`boolean` size is JVM dependent, but typically 1 byte is allocated.[^1][^2][^3]

### Example Code

```java
byte age = 25;
short year = 2025;
int population = 1400000000;
long stars = 70000000000000000L;
float piApprox = 3.14f;
double pi = 3.141592653589793;
char grade = 'A';
boolean isJavaFun = true;
```


### Key Characteristics

- **Predefined:** Fixed by Java, not user-defined.
- **Store single values:** Not collections or objects.
- **Pass by value:** Copies of values are passed to methods.
- **Fast \& memory-efficient.**


## 2. Non-Primitive (Reference) Data Types

**Non-primitive data types** are more complex and include anything that is not a primitive. They always **refer to objects in memory** (hence "reference types"). Examples:

- **Strings**
- **Arrays**
- **Classes**
- **Interfaces**
- **Enums**


### Example Code

```java
String name = "Java";
String s1 = new String("Welcome to Geekster !");
int[] scores = {95, 80, 100}; // Array of int
MyClass obj = new MyClass();  // Custom class

// Enum example
enum Day { MONDAY, TUESDAY, WEDNESDAY }
Day today = Day.MONDAY;
```


### Characteristics

- **Can be user-defined:** e.g., Classes, Interfaces, Enums.
- **Store references:** The variable holds a pointer to the actual object in heap memory.
- **Can be null:** Unlike primitives, reference types can be assigned `null`.
- **Variable size:** Memory depends on the object's structure.
- **Support methods:** You can invoke methods on them (e.g., `name.length()`).


## 3. Primitive vs Non-Primitive: Comparison Table

| Feature | Primitive Types | Non-Primitive Types |
| :-- | :-- | :-- |
| Defined by | Java language (predefined) | Programmers (except String) |
| Size | Fixed | Variable (object-dependent) |
| Stores | Actual value | Reference to object |
| Default Value | 0, 0.0, false, '\u0000', etc. | null |
| Methods Available | None | Yes (many built-in and user-defined) |
| Can be null? | No | Yes |
| Examples | `int`, `double`, `char`, `boolean` | `String`, `Array`, `Class`, `Enum` |

## 4. Practice \& Quiz

### Practice

1. **Declare a variable of every primitive type. Print their values.**
2. **Write a class `Person` with fields name (String), age (int), and print an array of `Person` objects.**
3. **What's the default value of an uninitialized array of booleans?**

### Quiz

1. **How many primitive data types does Java have? What are they?**
2. **How is `String` different from `char`?**
3. **Can a reference type be assigned `null`? What about a primitive?**
4. **What's the result of this expression: `true + false`? (Is it valid in Java?)**
5. **Is an array a primitive or non-primitive data type in Java? Explain.**

## 5. Key Takeaways

- **Primitive data types** are basic building blocks (numbers, chars, booleans) with fixed sizes.
- **Non-primitive data types** are derived from classes, can store multiple values, and have methods and properties.
- Mastery of both enables robust, efficient, and idiomatic Java code.[^2][^4][^5][^6][^1]

**You can copy this into `java-datatypes.md` as your next structured note! Let me know if you want more code exercises or deeper dives into special types (like `String`, `ArrayList`, or custom classes).**

<div style="text-align: center">⁂</div>

[^1]: https://www.w3schools.com/java/java_data_types.asp

[^2]: https://www.geeksforgeeks.org/java/java-data-types/

[^3]: https://www.coursera.org/in/articles/data-types-in-java

[^4]: https://www.geekster.in/articles/java-data-types/

[^5]: https://www.scaler.com/topics/non-primitive-data-types-in-java/

[^6]: https://www.w3schools.com/java/java_data_types_non-prim.asp

[^7]: https://en.wikibooks.org/wiki/Java_Programming/Primitive_Types

[^8]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

[^9]: https://en.wikipedia.org/wiki/Primitive_data_type

[^10]: https://cs.smu.ca/~porter/csc/465/notes/javapl_primitive.html

[^11]: https://monad.edu.in/img/media/uploads/data types in java.pdf

[^12]: https://www.baeldung.com/java-primitives

[^13]: https://www.digitalocean.com/community/tutorials/understanding-data-types-in-java

[^14]: https://www.shiksha.com/online-courses/articles/data-types-in-java-primitive-and-non-primitive-data-types/

