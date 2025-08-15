<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Now let's discuss these

https://jenkov.com/tutorials/java/classes.html
https://jenkov.com/tutorials/java/methods.html
https://jenkov.com/tutorials/java-collections/properties.html

Of course. This lesson will integrate the concepts of **Classes**, **Methods**, and the **Properties** class, drawing from the provided Jenkov tutorials. We will see how they work together, from defining the structure of your application with classes and methods to managing its configuration with properties.

***

# Java Fundamentals: Classes, Methods, and Properties

This lesson covers three essential building blocks of Java programming. We'll start with the high-level structure (Classes), move to the actions they perform (Methods), and finally, look at a practical utility for managing application data (Properties).

## 1. Java Classes: The Blueprint of Your Application

A **Java class** is the fundamental unit of organization in an Object-Oriented program. Think of it as a blueprint or a template that defines the structure and behavior for objects. A small application might have one class, but larger applications are split into multiple classes to keep the code manageable and structured.[^1]

### Building Blocks of a Class

A class is typically composed of:[^1]

* **Fields**: Variables that hold the state or data of an object.
* **Constructors**: Special methods used to create and initialize an object (an "instance" of the class).
* **Methods**: Blocks of code that define the actions or operations an object can perform.

**Example: A `ServerConfig` Class**
Let's define a class to represent a server's configuration.

```java
// Saved in a file named ServerConfig.java
public class ServerConfig {
    // Fields (data)
    public String host;
    public int port;
    public String protocol;

    // Constructor to initialize the object
    public ServerConfig(String host, int port, String protocol) {
        this.host = host;
        this.port = port;
        this.protocol = protocol;
    }

    // A simple class with no methods yet
}
```

An **object** is created from this class using the `new` keyword. Each object is a unique instance, with its own independent set of fields.[^1]

```java
ServerConfig primaryServer = new ServerConfig("api.example.com", 8080, "https");
ServerConfig backupServer = new ServerConfig("backup.example.com", 9090, "https");
```


## 2. Java Methods: Defining Behavior

**Methods** are where the operations of your program live. They are groups of Java statements located inside a class that perform a specific task. Methods allow you to break down complex code into smaller, reusable, and more understandable segments.[^2]

### Key Components of a Method

A method definition includes:[^2]

* **Access Modifier**: (e.g., `public`) Determines which other parts of your code can call the method.
* **Return Type**: The type of value the method sends back (e.g., `String`, `int`, or `void` if it returns nothing).
* **Method Name**: The name you use to call the method.
* **Parameters**: A list of input values the method can accept.

**Example: Adding a Method to `ServerConfig`**
Let's add a method to our `ServerConfig` class to generate a connection URL.

```java
public class ServerConfig {
    public String host;
    public int port;
    public String protocol;

    public ServerConfig(String host, int port, String protocol) {
        this.host = host;
        this.port = port;
        this.protocol = protocol;
    }

    // Method to generate the full URL
    public String getConnectionURL() {
        // Concatenates the fields to produce a result
        return this.protocol + "://" + this.host + ":" + this.port;
    }
}
```

Now, you can call this method on an object to get its behavior:

```java
ServerConfig primaryServer = new ServerConfig("api.example.com", 8080, "https");
String url = primaryServer.getConnectionURL(); // Calls the method
System.out.println(url); // Output: https://api.example.com:8080
```


## 3. Java Properties: Managing External Configuration

Hardcoding values like hostnames and ports directly in your code is inflexible. The **`java.util.Properties`** class provides a convenient way to manage configuration by storing and retrieving simple key-value pairs from a file. It functions like a Map specifically for Strings.[^3]

### Common `Properties` Operations

1. **Create and Load**: Create a `Properties` object and load data from a `.properties` file.[^3]
2. **Get Properties**: Use `getProperty()` to retrieve a value by its key.[^3]
3. **Store Properties**: Use `store()` to write the current properties back to a file.[^3]

**Example `.properties` File (`config.properties`)**
A properties file contains simple `key=value` pairs. Lines starting with `#` are comments.[^3]

```properties
# Server Configuration
server.host=localhost
server.port=9000
server.protocol=http
```

**Example: Using `Properties` to Configure an Object**
Let's modify our `main` logic to load configuration from the file.

```java
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("config.properties")) {
            // 1. Create a Properties object
            Properties props = new Properties();
            
            // 2. Load the file into the object
            props.load(reader);

            // 3. Get values using their keys
            String host = props.getProperty("server.host");
            int port = Integer.parseInt(props.getProperty("server.port"));
            String protocol = props.getProperty("server.protocol");

            // 4. Create our object using the loaded config
            ServerConfig configuredServer = new ServerConfig(host, port, protocol);

            // 5. Use the object's method
            System.out.println("Loaded connection URL: " + configuredServer.getConnectionURL());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Output:**

```
Loaded connection URL: http://localhost:9000
```

This approach separates configuration from code, making the application much more flexible.

***

## 4. Practice \& Quiz

### Practice

1. Create a class named `UserProfile`.
2. Add fields for `username` (String) and `theme` (String, e.g., "dark" or "light").
3. Add a method named `displayProfile()` that prints a message like "Welcome, [username]! Your theme is set to [theme]."
4. Create a `user.properties` file with keys `user.name` and `user.theme`.
5. In your `main` method, load these properties from the file, create a `UserProfile` object with the loaded data, and call its `displayProfile()` method.

### Quiz

1. According to Jenkov, what are the three main building blocks of a Java class?
2. What is the purpose of the `return` statement in a Java method?
3. What is the key difference between a class and an object?
4. Which method from the `Properties` class is used to read data from a `.properties` file?
5. Why is it better to use `setProperty()` and `getProperty()` instead of the `put()` and `get()` methods that a `Properties` object also has?

***

## Answers to Practice \& Quiz

### **Practice Answer**

**`user.properties` file:**

```properties
user.name=admin
user.theme=dark
```

**`UserProfile.java` file:**

```java
public class UserProfile {
    // Fields
    String username;
    String theme;

    // Constructor
    public UserProfile(String username, String theme) {
        this.username = username;
        this.theme = theme;
    }

    // Method
    public void displayProfile() {
        System.out.println("Welcome, " + this.username + "! Your theme is set to " + this.theme + ".");
    }
}
```

**`Main.java` file:**

```java
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties userProps = new Properties();
        try (FileReader reader = new FileReader("user.properties")) {
            userProps.load(reader);

            String name = userProps.getProperty("user.name");
            String theme = userProps.getProperty("user.theme");

            UserProfile profile = new UserProfile(name, theme);
            profile.displayProfile();

        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
        }
    }
}
```

**Output:**

```
Welcome, admin! Your theme is set to dark.
```


### **Quiz Answers**

1. The three main building blocks are **Fields**, **Constructors**, and **Methods**.[^1]
2. The `return` statement determines the value that a method sends back to the code that called it. Once a `return` statement is executed, the method stops executing.[^2]
3. A **class** is a template or blueprint, while an **object** is a concrete instance created from that class, with its own data.[^1]
4. The `load()` method is used to read data from a file into a `Properties` object.[^3]
5. The `Properties` class was mistakenly made a subclass of `Hashtable`. Using `put()` allows non-String keys and values, which defeats the purpose of the `Properties` class and can lead to `getProperty()` returning `null` unexpectedly because it expects String values.[^3]

<div style="text-align: center">⁂</div>

[^1]: https://jenkov.com/tutorials/java/classes.html

[^2]: https://jenkov.com/tutorials/java/methods.html

[^3]: https://jenkov.com/tutorials/java-collections/properties.html

[^4]: https://jenkov.com/tutorials/java/index.html

[^5]: https://jenkov.com/tutorials/java/main-method.html

[^6]: https://jenkov.com/tutorials/java/syntax.html

[^7]: https://jenkov.com/tutorials/java-reflection/dynamic-class-loading-reloading.html

[^8]: https://jenkov.com/tutorials/java-generics/methods.html

[^9]: https://jenkov.com/tutorials/java/modules.html

[^10]: https://jenkov.com/tutorials/javafx/properties.html

[^11]: https://jenkov.com/tutorials/java-io/overview.html

[^12]: https://jenkov.com/tutorials/java/interfaces.html

[^13]: https://jenkov.com/tutorials/ant/ant-properties.html

[^14]: https://www.youtube.com/user/jjenkov

[^15]: https://jenkov.com/tutorials/java-reflection/methods.html

[^16]: https://jenkov.com/tutorials/java-collections/index.html

[^17]: https://jenkov.com/tutorials/java-util-concurrent/index.html

[^18]: https://jenkov.com/tutorials/java/operations.html

[^19]: https://jenkov.com/tutorials/java-internationalization/resourcebundle.html

[^20]: https://www.youtube.com/watch?v=mTGdtC9f4EU

