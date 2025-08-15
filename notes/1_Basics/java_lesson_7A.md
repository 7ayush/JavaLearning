## **7. Practice \& Quiz**

### **Practice Part**

#### **1. Instance variable vs. Static variable example**

```java
class Demo {
    // Instance variable (unique to each object)
    int instanceVar;

    // Static variable (shared across all objects)
    static int staticVar;

    Demo(int instanceVar, int staticVarValue) {
        this.instanceVar = instanceVar;
        staticVar = staticVarValue;
    }
}

public class Main {
    public static void main(String[] args) {
        Demo obj1 = new Demo(10, 100);
        Demo obj2 = new Demo(20, 200);

        System.out.println("obj1.instanceVar: " + obj1.instanceVar); // 10
        System.out.println("obj1.staticVar: " + obj1.staticVar);     // 200 (changed by obj2)

        System.out.println("obj2.instanceVar: " + obj2.instanceVar); // 20
        System.out.println("obj2.staticVar: " + obj2.staticVar);     // 200 (same for all)
    }
}
```

✅ **Observation:**

- **Instance variable** → unique for each object (obj1 = 10, obj2 = 20).
- **Static variable** → shared across all objects (last assigned value seen everywhere).

***

#### **2. Local variable and nested block variable scope**

```java
public class ScopeExample {
    public void showScope() {
        int localVar = 5; // Local to method

        {
            int blockVar = 10; // Local to this block only
            System.out.println("Inside block → localVar: " + localVar);
            System.out.println("Inside block → blockVar: " + blockVar);
        }

        System.out.println("Outside block → localVar: " + localVar);
        // System.out.println(blockVar); // ❌ Error: blockVar not accessible here
    }

    public static void main(String[] args) {
        new ScopeExample().showScope();
    }
}
```

✅ **Observation:**

- **Local variables** are accessible throughout the method where they are declared.
- **Block variables** exist only within `{}` block’s scope.

***

## **Quiz Answers**

**1. Difference between a local variable and an instance variable?**

- **Local Variable:** Declared inside a method, constructor, or block; exists only during method execution; must be initialized before use.
- **Instance Variable:** Declared in a class but outside any method; belongs to an object; gets default values if not initialized.

***

**2. How can you access a shadowed instance variable inside a method?**

- Use `this.instanceVariableName` to refer to the current object's variable when a method's local variable has the same name.
Example:

```java
class Test {
    int value = 10;
    void setValue(int value) {
        this.value = value; // Without 'this', it would assign local 'value' to itself
    }
}
```


***

**3. Can a static variable be accessed without creating an object?**
✅ **Yes** — You can access a static variable directly using the **class name**:

```java
ClassName.staticVariable
```

Example:

```java
System.out.println(Demo.staticVar);
```


***

**4. What is variable shadowing and why can it be confusing?**

- **Variable shadowing** occurs when a local variable or parameter has the same name as an instance variable (or parent class variable), hiding it within the current scope.
- **Why confusing?**
Because you might unintentionally use the local version, ignoring the actual object field, leading to unexpected results.

***

If you want, I can now **merge the practice and quiz into a single Java file** so you can run and see **all the behaviors in one execution**.
Do you want me to prepare that combined example?

