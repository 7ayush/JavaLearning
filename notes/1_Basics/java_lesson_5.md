<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Java Program Life Cycle \& JVM Execution Lifecycle

Welcome to your advanced Java study notes! In this lesson, we’ll cover the **life cycle of a Java program** from source code to execution, and we’ll demystify how the **Java Virtual Machine (JVM)** loads, links, initializes, executes, and ultimately unloads Java classes. This lesson is split into two major sections:

1. **The Basic Java Program Life Cycle**
2. **Deep Dive: JVM Execution Lifecycle**

Throughout the lesson, you’ll find code examples, clear diagrams (described), and exercises for mastery.

## 1. The Basic Java Program Life Cycle

### A. Editing

- **Write Java code** in any text editor (Notepad, IntelliJ IDEA, Eclipse, etc.).
- Save the file with a `.java` extension, **matching the public class name** (e.g., `Sample.java` for class `Sample`).

```java
// Sample.java
public class Sample {
    public static void main(String[] args) {
        System.out.println("Hello, Java Life Cycle!");
    }
}
```

*Tip:* Always match the filename to the public class for smooth compilation.

### B. Compiling

- Use the **Java compiler** (`javac`) to convert your `.java` file into **bytecode**:

```
javac Sample.java
```

- This produces a file: `Sample.class`.


#### What is Bytecode?

- **Platform-independent, intermediate code**.
- Not machine language—runs on **any system with a JVM**.


### C. Execution

- The `.class` file is executed by the **Java Virtual Machine (JVM)**.
- **JVM** translates bytecode into machine code instructions for your CPU.

```
java Sample
```

- The output: `Hello, Java Life Cycle!`

**Quick Recap Table:**


| Stage | Tool | Input | Output |
| :-- | :-- | :-- | :-- |
| Editing | Text editor | `.java` file | Source code |
| Compiling | `javac` | `.java` file | `.class` file |
| Executing | `java` | `.class` file | Program output |

## 2. Deep Dive: JVM Execution Lifecycle

The JVM manages Java application execution through **six main stages**:

1. **Loading**
2. **Linking**
3. **Initializing**
4. **Instantiating**
5. **Finalizing**
6. **Unloading**

### 2.1 Loading

- **Class loading**: The JVM finds your `.class` file and loads its **binary** form, creating a `Class` object.
- **Class Loaders:**
    - **Bootstrap ClassLoader**: Loads core Java classes.
    - **Extension/Application ClassLoader**: Loads custom classes (yours \& libraries).


#### Example: Basic Custom ClassLoader

```java
public class CustomClassLoader extends ClassLoader {
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        // Custom class loading logic
        return super.loadClass(name);
    }
}
```


### 2.2 Linking

Linking prepares your loaded class for execution:

- **Verification**: Checks for correct bytecode and valid structure.
- **Preparation**: Allocates memory for static fields; sets defaults.
- **Resolution**: Symbolic references (like `OtherClass.field`) are linked (often lazily).


### 2.3 Initializing

- **Static initializers** and **static fields** are set up in order of appearance.
- **Superclass initializers** run first.

```java
class Main {
    static int x = 1;
    static int y;
    static {
        y = x + 1;
    }
    static int z = x + y;
    public static void main(String[] args) {
        System.out.println(x + ", " + y + ", " + z); // 1, 2, 3
    }
}
```


### 2.4 Instantiating

- Creating objects using `new` allocates heap memory, calls the constructor, and returns a reference.

```java
Point magicPoint = new Point(42, 42);
```


### 2.5 Finalizing

- **Before garbage collection**, the JVM calls an object’s `finalize()` method (if overridden) for cleanup.
- **Note**: `finalize()` is not guaranteed to run and is deprecated since Java 9—use `try-with-resources` or explicit resource management instead.

```java
@Override
protected void finalize() throws Throwable {
    // Clean up resources
    super.finalize();
}
```


### 2.6 Unloading

- The JVM may *unload* classes if the custom class loader that loaded them is garbage collected.
- Built-in (bootstrap) classes are typically **never unloaded** during program execution.


## 3. Full Life Cycle Diagram (described)

```
[Source Editing]
     |
     v
[Compiling javac]
     |
     v
[Bytecode (.class) Loading by JVM]
     |
     v
[Linking: Verify -> Prepare -> (Resolve)]
     |
     v
[Initializing: static fields, blocks]
     |
     v
[Main method executes]
     |
     v
[Object Instantiation - Usage]
     |
     v
[Finalization / Garbage Collection]
     |
     v
[Unloading (rare for custom loaders)]
     |
     v
[Program Exit]
```


## 4. Exercises \& Quiz

### Practice 1: Compilation

*Given a file `Test.java` containing a public class, what happens if you save the file as `Alpha.java` and try to compile?*

### Practice 2: JVM Load Order

*In what order are static initializers run when loading a class hierarchy (e.g., class A extends B)?*

### Mini Quiz

1. **What file does `javac` produce?**
2. **What is the main difference between bytecode and machine code?**
3. **Is the `finalize()` method guaranteed to run every time an object is garbage collected?**
4. **How does the JVM translate bytecode into instructions for different CPU architectures?**
5. **Under what circumstances will class unloading occur?**

## 5. Key Takeaways

- Java separates **compilation** and **execution** for portability.
- The **JVM** manages several sophisticated steps beyond “just running” your code.
- **Class loaders** and the **GC** allow for dynamic loading/unloading of code.
- Resource management is your responsibility; never rely solely on `finalize()`.

You can copy and paste this into your own `.md` file as `java-lifecycle.md`. Let me know if you’d like code files, further diagrams, or expanded quizzes!

**References:**
Based on content from.[^1][^2]

<div style="text-align: center">⁂</div>

[^1]: https://www.startertutorials.com/corejava/life-cycle-java-program.html

[^2]: https://www.cesarsotovalero.net/blog/how-the-jvm-executes-java-code.html

