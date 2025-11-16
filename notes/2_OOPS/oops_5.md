<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Now let's discuss

[https://jenkov.com/tutorials/java/inheritance.html](https://jenkov.com/tutorials/java/inheritance.html)
[https://www.digitalocean.com/community/tutorials/inheritance-java-example](https://www.digitalocean.com/community/tutorials/inheritance-java-example)

Inheritance lets one class reuse and specialize the behavior of another, creating hierarchies that support code reuse, substitutability, and polymorphism. In Java, classes inherit a single superclass via extends, can override methods, and use super to reach superclass members. Below is a concise, example-rich guide aligned with Jenkov and DigitalOcean.

### Core ideas

- A subclass “is a” specialized form of its superclass; it inherits accessible fields and methods and may add or override behavior.[^1][^2]
- Java supports single inheritance for classes (multiple via interfaces), forming a hierarchy with Object at the root.[^2]
- Use extends to declare inheritance; use @Override to make overriding explicit and safe.[^1][^2]


### Declaring inheritance

```java
class Vehicle {
    protected String licensePlate;
    public void setLicensePlate(String lp) { this.licensePlate = lp; }
    public String getLicensePlate() { return licensePlate; }
}

class Car extends Vehicle {
    private int seats;
    @Override
    public void setLicensePlate(String lp) { this.licensePlate = lp.toUpperCase(); }
    public int getSeats() { return seats; }
}
```

- Car inherits Vehicle’s accessible members and overrides setLicensePlate.[^2][^1]


### What is inherited and accessible

- Inherited: public and protected members; package-private if in same package; private never directly.[^1]
- Fields are not overridden; if redeclared in subclass, they are shadowed. Methods can be overridden (same signature).[^1]


### Constructors and super

- Constructors aren’t inherited. A subclass constructor must invoke a superclass constructor (implicitly super() if available).[^2][^1]

```java
class Truck extends Vehicle {
    private final int capacity;
    Truck(String lp, int capacity) {
        super();           // implicit if Vehicle has no-arg
        this.capacity = capacity;
        setLicensePlate(lp);
    }
}
```


### Upcasting, downcasting, instanceof

```java
Car car = new Car();
Vehicle v = car;              // upcast: always safe
if (v instanceof Car) {
    Car c2 = (Car) v;         // downcast: safe only if actual type matches
}
```

- Wrong downcasts throw ClassCastException at runtime. Prefer instanceof checks.[^2][^1]


### Overriding, polymorphism, and super

- Dynamic dispatch calls the most specific override at runtime via a superclass reference.[^1]

```java
Vehicle v2 = new Car();
v2.setLicensePlate("abc");    // calls Car#setLicensePlate
```

- Use super.method(...) to call the superclass implementation when needed.[^1]


### Field shadowing vs method overriding

```java
class Vehicle { String tag = "V"; }
class Car extends Vehicle { String tag = "C"; }
Vehicle v = new Car();
System.out.println(v.tag);    // prints "V" (fields resolved by reference type)
```

- Methods are polymorphic; fields are not.[^1]


### Final and abstract in hierarchies

- final class cannot be extended; final method cannot be overridden.[^1]
- abstract class can contain abstract methods and cannot be instantiated; subclasses must implement abstract methods.[^1]


### When to use inheritance vs composition

- Prefer inheritance when there’s a strong “is-a” relationship and polymorphic substitution is needed.[^3][^1]
- Prefer composition (“has-a”) to assemble behavior and avoid tight coupling; often more flexible.[^3]


### Practical example (DigitalOcean-style)

```java
class Animal {
    private boolean vegetarian;
    private String eats;
    private int legs;

    public Animal(boolean veg, String food, int legs) {
        this.vegetarian = veg; this.eats = food; this.legs = legs;
    }
    public boolean isVegetarian() { return vegetarian; }
    public String getEats() { return eats; }
    public int getNoOfLegs() { return legs; }
}

class Cat extends Animal {
    private String color;
    public Cat(boolean veg, String food, int legs, String color) {
        super(veg, food, legs);
        this.color = color;
    }
    public String getColor() { return color; }
}
```

- Cat reuses Animal’s state/behavior and adds color; constructors chain via super(...).[^2]


### do’s and don’ts

- Do use @Override on overrides for compiler checks.[^1]
- Don’t expose superclass internals; keep fields private/protected appropriately.[^1]
- Don’t downcast without instanceof; avoid fragile casts.[^1]
- Consider composition or interfaces to avoid deep, brittle hierarchies.[^3]


### Practice

- Refactor a hierarchy Vehicle → Car/Truck; add override of toString() and ensure polymorphic calls via Vehicle references.[^1]
- Demonstrate a failing downcast and guard it with instanceof to avoid ClassCastException.[^2]
- Replace an inheritance-based Logger → FileLogger/ConsoleLogger with a Logger interface and composition to compare flexibility.[^3]


### Quiz (answers included)

1) Which members are inherited by a subclass in a different package?

- public and protected; package-private only if in same package; private never directly.[^1]

2) Why does v.tag print Vehicle’s field when v is a Vehicle pointing to a Car?

- Field access is resolved at compile time by reference type; fields are shadowed, not overridden.[^1]

3) When is downcasting safe?

- Only when the actual runtime object is an instance of the target subclass; use instanceof to check.[^2][^1]

4) What must a subclass constructor do with respect to the superclass?

- Invoke a superclass constructor (implicitly super() if accessible no-arg exists), and it must be the first statement.[^2][^1]

5) Give two cases to favor composition over inheritance.

- When behavior varies independently of type, or when there isn’t a strong “is-a” and polymorphic substitution need; to reduce coupling and increase flexibility.[^3]

Citations: Jenkov on inheritance fundamentals, overriding, constructors, access and field shadowing; DigitalOcean on extends usage, up/downcasting, and examples.[^2][^1]
<span style="display:none">[^10][^11][^12][^13][^14][^15][^16][^17][^4][^5][^6][^7][^8][^9]</span>

<div align="center">⁂</div>

[^1]: https://jenkov.com/tutorials/java/classes.html

[^2]: https://www.digitalocean.com/community/tutorials/multiple-inheritance-in-java

[^3]: https://www.digitalocean.com/community/tutorials/composition-vs-inheritance

[^4]: https://jenkov.com/tutorials/java/inheritance.html

[^5]: https://www.digitalocean.com/community/tutorials/inheritance-java-example

[^6]: https://jenkov.com/tutorials/java/index.html

[^7]: https://jenkov.com/tutorials/java/nested-classes.html

[^8]: https://www.linkedin.com/posts/jakob-jenkov-4a3a8_java-tutorial-activity-7265286622558998528-thSJ

[^9]: https://www.youtube.com/user/jjenkov

[^10]: https://www.reddit.com/r/learnjava/comments/cgov5p/jenkovs_tutorial_on_java_threading_is_really_good/

[^11]: https://www.codecademy.com/learn/learn-java/modules/learn-java-inheritance-and-polymorphism/cheatsheet

[^12]: https://jenkov.com/tutorials/java/constructors.html

[^13]: https://www.youtube.com/watch?v=Zs342ePFvRI

[^14]: https://www.digitalocean.com/community/tutorials/oops-concepts-java-example

[^15]: https://www.studocu.com/en-us/document/upper-iowa-university/computers/cse-215-java-essential-resources-for-self-learning/141629336

[^16]: https://www.digitalocean.com/community/tutorials/composition-in-java-example

[^17]: https://www.digitalocean.com/community/tutorials/java-design-patterns-example-tutorial

