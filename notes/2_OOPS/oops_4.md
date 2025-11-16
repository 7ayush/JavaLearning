<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Now let's discuss about Lifecycle of an object in java

Of course. Let's delve into the lifecycle of an object in Java, from its creation to its eventual destruction. Understanding this process is key to managing memory and writing efficient, bug-free applications.

***

# The Lifecycle of a Java Object

Every object in a Java program goes through a distinct lifecycle, from its "birth" to its "death." This process is managed by the Java Virtual Machine (JVM). While developers are responsible for creating objects, the JVM's Garbage Collector is responsible for destroying them.

The lifecycle can be broken down into several key stages:

### 1. Creation

An object's life begins when it is created. This single step involves three distinct actions:

* **Declaration**: You declare a variable that will refer to the object.

```java
// Declares a reference variable 'myCar', but no object is created yet.
Car myCar; 
```

* **Instantiation**: The `new` keyword is used to request memory for the object from the JVM. This memory is allocated on the **heap**.

```java
myCar = new Car();
```

* **Initialization**: After memory is allocated, the object's **constructor** is called. This special method initializes the new object and its fields, setting its initial state.

These three steps are often combined into a single line:

```java
// Declaration, Instantiation, and Initialization all in one.
Car myCar = new Car(); 
```


### 2. In Use (Reachable)

After an object is created and assigned to a reference variable, it is considered **in use** or **reachable**. This means there is at least one active reference pointing to the object in memory. As long as an object is reachable, it is considered "alive" and will not be destroyed by the JVM.

A reference is considered "active" if it can be accessed from a **Garbage Collection (GC) Root**. GC Roots include:

* Local variables on the current thread's stack.
* Static variables of any class.
* References from JNI (Java Native Interface).

```java
public void process() {
    List<String> userList = new ArrayList<>(); // userList is a GC Root.
    // The ArrayList object is now 'in use'.
}
```


### 3. Unreachable / Invisible

An object becomes a candidate for garbage collection when it is no longer reachable. This happens when:

* **The reference variable goes out of scope.** For example, when a method finishes, all its local variables (and the objects they point to, if there are no other references) become unreachable.

```java
void myMethod() {
    String temporary = "Hello"; 
} // 'temporary' goes out of scope here; the "Hello" object is now unreachable.
```

* **The reference is explicitly set to `null`**.

```java
Car myCar = new Car();
myCar = null; // The Car object is now unreachable.
```

* **The reference is reassigned to another object**.

```java
Car car1 = new Car();
Car car2 = new Car();
car1 = car2; // The original object pointed to by car1 is now unreachable.
```


At this stage, the object still exists in memory, but the program can no longer access it.

### 4. Collected (Candidate for Destruction)

The **Garbage Collector (GC)** is a background process in the JVM that periodically scans the heap for unreachable objects. When it finds an unreachable object, it marks it as "collected" and ready for destruction.

You, as a developer, cannot control exactly when the GC will run. You can suggest it run using `System.gc()`, but this is not a guarantee.

### 5. Finalized (Optional)

Before an object is destroyed, the GC checks if the object's class has a `finalize()` method. If it does, the object is placed in a finalization queue, and its `finalize()` method will be called at some later point.

The `finalize()` method was intended for resource cleanup (like closing files or network connections). However, **it has been deprecated since Java 9 and should be avoided**.

* It is not guaranteed to run at any specific time, or even at all.
* It can significantly complicate garbage collection and slow down performance.
* Modern alternatives like `try-with-resources` are far superior for resource management.


### 6. De-allocated (Destroyed)

After the object has been collected (and finalized, if applicable), the Garbage Collector reclaims the memory occupied by the object. This memory is then returned to the heap and can be used for new object allocations. At this point, the object is completely gone.

## Summary of the Lifecycle

| Stage | Description |
| :-- | :-- |
| **1. Created** | Memory is allocated on the heap via `new`, and the constructor is called. |
| **2. In Use (Reachable)** | The object is referenced by an active part of the program (a GC Root). |
| **3. Unreachable** | All references to the object are lost (e.g., variable goes out of scope or is set to `null`). |
| **4. Collected** | The Garbage Collector identifies the object as unreachable. |
| **5. Finalized (Optional)** | If a `finalize()` method exists, it is scheduled to be run. **(Deprecated)** |
| **6. De-allocated** | The memory is reclaimed by the JVM and returned to the heap. |


***

## Practice \& Quiz

### Practice

1. **Scope and Reachability**: Write a method that creates a `Person` object. Inside a loop within that method, create a temporary `Address` object. After the loop, print the `Person` object. Explain at which point the `Address` objects become unreachable.
2. **Nulling a Reference**: Create two `StringBuilder` objects, `sb1` and `sb2`. Assign a value to `sb1`. Then, assign `sb2 = sb1`. Finally, set `sb1 = null`. Is the original `StringBuilder` object reachable? Why?
3. **Forcing GC (For Demonstration)**: Create a large number of objects in a loop. After the loop, set the reference to `null` and call `System.gc()`. Add a `finalize()` method to your object's class that prints a message. Observe if and when the message is printed (note: results may vary).

### Quiz

1. Where in memory are Java objects allocated?
2. What is a "GC Root"? Give one example.
3. What is the primary condition for an object to become eligible for garbage collection?
4. Is it guaranteed that the `finalize()` method will be called before an object is destroyed?
5. Who is responsible for de-allocating an object's memory in Java?

***

## Answers to Practice \& Quiz

### **Practice Answers**

1. **Scope and Reachability**: The `Address` objects become unreachable at the **end of each loop iteration**. The reference variable for the `Address` object is local to the loop's block, so it goes out of scope, making the object a candidate for garbage collection. The `Person` object remains reachable until the method itself finishes.
2. **Nulling a Reference**: **Yes**, the original `StringBuilder` object is still reachable. Even though `sb1` was set to `null`, `sb2` still holds a reference to that same object. The object will only become unreachable when `sb2` also goes out of scope or is set to `null`.
3. **Forcing GC**: The `finalize()` message may be printed, but it is not guaranteed. The call to `System.gc()` is only a suggestion to the JVM. The exact timing and behavior depend on the JVM implementation and the current state of the system. This exercise demonstrates the unreliability of `finalize()`.

### **Quiz Answers**

1. Java objects are allocated on the **heap**.
2. A "GC Root" is a special variable that is assumed to be reachable by the garbage collector. An example is a **local variable** on a method's stack or a **static variable** of a class.
3. The primary condition is that the object becomes **unreachable**—meaning there are no more active references pointing to it from any GC Root.
4. **No**, it is not guaranteed. The `finalize()` method might never be called, especially if the program terminates before the GC has a chance to run it.
5. The **Java Virtual Machine (JVM)**, specifically its **Garbage Collector (GC)** component, is responsible for de-allocating memory.
<span style="display:none">[^1][^2][^3][^4][^5][^6][^7][^8]</span>

<div align="center">⁂</div>

[^1]: https://www.scientecheasy.com/2020/06/life-cycle-of-object-in-java.html/

[^2]: https://www.nv5geospatialsoftware.com/docs/The_Object_Lifecycle_1.html

[^3]: https://www.codekru.com/java/object-life-cycle-in-java

[^4]: https://dzone.com/articles/ocajp-7-object-lifecycle-java

[^5]: https://www.iitk.ac.in/esc101/05Aug/tutorial/java/data/objects.html

[^6]: https://www.cs.cmu.edu/afs/cs/academic/class/15212-s98/www/java/tutorial/java/javaOO/lifecycle.html

[^7]: https://docs.oracle.com/javaee/7/api/javax/faces/lifecycle/Lifecycle.html

[^8]: https://www.geeksforgeeks.org/advance-java/hibernate-lifecycle/

