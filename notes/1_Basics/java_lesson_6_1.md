<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Also provide answers to the question QnA and the homework in the end of it.

Certainly! Here are the **answers and explanations** for the Practice, Quiz, and Homework questions at the end of the _Java Data Types_ lesson. You can append this to your `java-datatypes.md` notes.

# Java Data Types

## Answers to Practice, Quiz, and Homework

### **Practice Answers**

1. **Declare a variable of every primitive type. Print their values.**
```java
public class PrimitivesDemo {
    public static void main(String[] args) {
        byte b = 10;
        short s = 1000;
        int i = 100000;
        long l = 10000000000L;
        float f = 3.14f;
        double d = 2.718281828459045;
        char c = 'J';
        boolean flag = true;

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + flag);
    }
}
```

**Output:**

```
byte: 10
short: 1000
int: 100000
long: 10000000000
float: 3.14
double: 2.718281828459045
char: J
boolean: true
```

2. **Write a class `Person` with fields name (String), age (int), and print an array of `Person` objects.**
```java
class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class PersonArrayTest {
    public static void main(String[] args) {
        Person[] people = {
            new Person("Ashok", 25),
            new Person("Divya", 30),
            new Person("Kiran", 22)
        };

        for (Person p : people) {
            p.printInfo();
        }
    }
}
```

3. **What's the default value of an uninitialized array of booleans?**

- The default value for elements of a boolean array is **`false`**.

Example:

```java
boolean[] arr = new boolean[3];
System.out.println(arr[1]); // Prints: false
```


### **Quiz Answers**

1. **How many primitive data types does Java have? What are they?**

- Java has **eight** primitive data types:
    - `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`

2. **How is `String` different from `char`?**

- `char` is a **primitive** data type, representing a single Unicode character (e.g., `'A'`).
- `String` is a **non-primitive (reference)** type, representing a sequence of characters (e.g., `"Hello"`).

3. **Can a reference type be assigned `null`? What about a primitive?**

- Reference types (like `String`, `Array`, custom classes) **can** be assigned `null`.
- Primitive types **cannot** be assigned `null`. They always have a default value (`0`, `false`, etc.).

4. **What's the result of this expression: `true + false`? (Is it valid in Java?)**

- **It is NOT valid.** Java does **not** allow arithmetic operations on booleans. This code will not compile.

5. **Is an array a primitive or non-primitive data type in Java? Explain.**

- **Non-primitive.** Arrays in Java are objects. Even for arrays of primitive elements (e.g., `int[]`), the array itself is a reference type.


## **Key Concepts Recap**

- Primitive types: Fast, basic, fixed-size, no methods, can't be `null`.
- Non-primitive types: More complex, reference objects, can be `null`, have methods/properties.

**Feel free to add these answers in your notes under a section like “Q\&A Solutions” or after the respective questions for quick review.
Let me know if you’d like further explanations or more complex exercises!**

