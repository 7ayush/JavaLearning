# Java Packages, Import/Export, and Standard I/O

This comprehensive lesson covers three fundamental aspects of Java programming: organizing code with packages, managing dependencies with import statements, and handling input/output through standard streams.

## 1. Java Packages: Organizing Your Code

A **package** in Java is a namespace that organizes a group of related classes and interfaces. Think of packages as folders in a file system that help organize your code, prevent naming conflicts, and control access.

### Why Use Packages?

- **Avoid naming conflicts**: You can have classes with the same name in different packages
- **Better organization**: Group related functionality together
- **Access control**: Packages work with access modifiers for encapsulation
- **Easier maintenance**: Find and manage code more effectively

### Built-in vs User-defined Packages

**Built-in Packages** are part of the Java API:
- `java.lang` - Core language classes (automatically imported)
- `java.util` - Utility classes like collections, Scanner
- `java.io` - Input/output classes
- `java.net` - Networking classes

**User-defined Packages** are created by developers to organize their own code.

### Creating a Package

To create a package, use the `package` statement as the **first line** of your Java file:

```java
package com.company.projectname;

public class MyClass {
    // class content
}
```

The package name corresponds to the directory structure:
```
src/
└── com/
    └── company/
        └── projectname/
            └── MyClass.java
```

### Package Naming Conventions

- Use lowercase letters
- Follow reverse domain name convention: `com.company.project`
- Use dots to separate levels: `com.mycompany.utilities.math`

**Example: Creating a User Package**

```java
// File: src/com/myapp/utils/Calculator.java
package com.myapp.utils;

public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
}
```

## 2. Import Statements: Using Code from Other Packages

The `import` statement allows you to use classes from other packages without writing their full qualified names.

### Types of Import Statements

**1. Single Class Import**
```java
import java.util.Scanner;
import java.util.ArrayList;
```

**2. Package Import (Import on Demand)**
```java
import java.util.*;  // Imports all classes from java.util
```

**3. Static Import** (for static members)
```java
import static java.lang.Math.PI;
import static java.lang.System.out;
```

### Import Rules and Best Practices

- Import statements come after the package declaration but before class definitions
- The `java.lang` package is automatically imported
- Specific imports are preferred over wildcard imports for clarity
- Unused imports should be removed

**Example: Using Imports**

```java
package com.myapp.main;

import java.util.Scanner;
import java.util.ArrayList;
import com.myapp.utils.Calculator;  // Our custom class

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        int result = Calculator.add(5, 3);
        System.out.println("Result: " + result);
    }
}
```

### Fully Qualified Names

Instead of importing, you can use the full package path:

```java
java.util.Scanner scanner = new java.util.Scanner(System.in);
java.util.Date today = new java.util.Date();
```

## 3. Standard Input/Output (stdin/stdout)

Java provides three standard streams for console-based input and output:

- **`System.in`** - Standard input (stdin)
- **`System.out`** - Standard output (stdout)  
- **`System.err`** - Standard error (stderr)

### Standard Output (`System.out`)

The most common way to output data to the console:

```java
// Print with newline
System.out.println("Hello World!");

// Print without newline
System.out.print("Hello ");
System.out.print("World!");

// Formatted output
System.out.printf("Name: %s, Age: %d%n", "John", 25);
```

### Standard Input (`System.in`)

Reading input requires helper classes since `System.in` is a raw `InputStream`.

**Using Scanner (Recommended for Beginners)**

```java
import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.println("Hello " + name + ", you are " + age + " years old.");
        
        scanner.close();
    }
}
```

**Using BufferedReader (More Efficient)**

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedInputExample {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter a line: ");
        String line = reader.readLine();
        
        System.out.println("You entered: " + line);
        
        reader.close();
    }
}
```

### Standard Error (`System.err`)

Used for error messages and diagnostics:

```java
System.out.println("This is normal output");
System.err.println("This is an error message");
```

### Comparison: Scanner vs BufferedReader

| Feature | Scanner | BufferedReader |
|---------|---------|----------------|
| **Ease of Use** | Very easy, built-in parsing | More complex, manual parsing |
| **Performance** | Slower | Faster |
| **Methods** | `nextInt()`, `nextDouble()`, `nextLine()` | `readLine()` only |
| **Package** | `java.util` | `java.io` |

## 4. Practical Examples

### Complete Package Structure Example

```
src/
└── com/
    └── mycompany/
        └── calculator/
            ├── Main.java
            ├── operations/
            │   ├── BasicOperations.java
            │   └── AdvancedOperations.java
            └── utils/
                └── InputValidator.java
```

**BasicOperations.java**
```java
package com.mycompany.calculator.operations;

public class BasicOperations {
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double subtract(double a, double b) {
        return a - b;
    }
}
```

**Main.java**
```java
package com.mycompany.calculator;

import java.util.Scanner;
import com.mycompany.calculator.operations.BasicOperations;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        double sum = BasicOperations.add(num1, num2);
        System.out.println("Sum: " + sum);
        
        scanner.close();
    }
}
```

## 5. Practice & Quiz

### Practice

1. **Package Creation**: Create a package structure `com.student.library` with classes `Book` and `Author`. The `Book` class should have fields for title, author, and ISBN. Create a main class in `com.student.main` that uses these classes.

2. **Import Exercise**: Write a program that uses `Scanner` for input, `ArrayList` to store numbers, and `Collections` to sort them. Use appropriate import statements.

3. **I/O Challenge**: Create a program that reads student names and grades from the user using `BufferedReader`, stores them, and prints a formatted report using `System.out.printf()`.

### Quiz

1. What is the purpose of the `package` statement in Java?
2. What's the difference between `import java.util.Scanner;` and `import java.util.*;`?
3. Which Java package is automatically imported in every Java program?
4. What are the three standard streams available in Java?
5. When would you choose `BufferedReader` over `Scanner` for input?

---

## Answers to Practice & Quiz

### **Practice Answers**

**1. Package Creation**

```java
// File: src/com/student/library/Author.java
package com.student.library;

public class Author {
    private String name;
    private String nationality;
    
    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }
    
    // Getters
    public String getName() { return name; }
    public String getNationality() { return nationality; }
}
```

```java
// File: src/com/student/library/Book.java
package com.student.library;

public class Book {
    private String title;
    private Author author;
    private String isbn;
    
    public Book(String title, Author author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author.getName());
        System.out.println("ISBN: " + isbn);
    }
}
```

```java
// File: src/com/student/main/LibraryMain.java
package com.student.main;

import com.student.library.Book;
import com.student.library.Author;

public class LibraryMain {
    public static void main(String[] args) {
        Author author = new Author("George Orwell", "British");
        Book book = new Book("1984", author, "978-0-452-28423-4");
        
        book.displayInfo();
    }
}
```

**2. Import Exercise**

```java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class NumberSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter numbers (type -1 to stop):");
        
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            numbers.add(num);
        }
        
        Collections.sort(numbers);
        System.out.println("Sorted numbers: " + numbers);
        
        scanner.close();
    }
}
```

**3. I/O Challenge**

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> students = new HashMap<>();
        
        System.out.println("Enter student data (name grade), or 'quit' to finish:");
        
        while (true) {
            String input = reader.readLine();
            if (input.equals("quit")) break;
            
            String[] parts = input.split(" ");
            String name = parts[0];
            double grade = Double.parseDouble(parts[1]);
            students.put(name, grade);
        }
        
        System.out.println("\n--- Student Report ---");
        for (Map.Entry<String, Double> entry : students.entrySet()) {
            System.out.printf("%-15s: %.2f%n", entry.getKey(), entry.getValue());
        }
        
        reader.close();
    }
}
```

### **Quiz Answers**

1. **What is the purpose of the `package` statement in Java?**
   The `package` statement defines the namespace for a class, organizes code into logical groups, prevents naming conflicts, and controls access. It must be the first non-comment line in a Java file.

2. **What's the difference between `import java.util.Scanner;` and `import java.util.*;`?**
   The first imports only the `Scanner` class specifically. The second imports all classes from the `java.util` package on demand. Specific imports are preferred for clarity and to avoid potential naming conflicts.

3. **Which Java package is automatically imported in every Java program?**
   The `java.lang` package is automatically imported. This includes fundamental classes like `String`, `Object`, `Integer`, `System`, etc.

4. **What are the three standard streams available in Java?**
   - `System.in` (standard input/stdin)
   - `System.out` (standard output/stdout)  
   - `System.err` (standard error/stderr)

5. **When would you choose `BufferedReader` over `Scanner` for input?**
   Choose `BufferedReader` when you need better performance (especially for large amounts of input), when working with competitive programming, or when you only need to read lines of text. `Scanner` is better for parsing different data types easily.