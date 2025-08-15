<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Arrays

Reference https://jenkov.com/tutorials/java/arrays.html

This is a fundamental data structure, and we'll cover everything from the basics to advanced manipulations using the `java.util.Arrays` utility class.

Here is your comprehensive lesson on Java Arrays.

***

# Java Arrays: A Comprehensive Guide

An **array** in Java is a container object that holds a fixed number of values of a single type. Think of it as a collection of variables of the same data type, stored in a contiguous block of memory. The length of an array is established when the array is created, and after creation, its length is fixed.[^1]

### Key Characteristics of Arrays

* **Fixed Size**: Once an array is created, its size cannot be changed.[^1]
* **Homogeneous**: All elements in an array must be of the same data type.[^1]
* **Indexed**: Elements are stored and accessed using a zero-based index (the first element is at index 0, the second at index 1, and so on).[^1]

***

## 1. Declaring and Instantiating Arrays

Working with arrays is a two-step process: you first declare a variable to hold the array, and then you instantiate (create) the array itself.[^1]

### A. Declaring an Array Variable

You declare an array variable by specifying the data type followed by square brackets `[]`.[^1]

**Syntax:**

```java
dataType[] arrayName;
```

**Examples:**

```java
int[] numbers;
String[] names;
double[] prices;
```

While you can also place the brackets after the variable name (e.g., `int numbers[];`), placing them after the type is the standard and recommended convention in Java as it clearly indicates the variable's type is an array of `int`.[^1]

### B. Instantiating an Array

Declaration only creates a reference; it doesn't create the actual array. To create it, you use the `new` keyword and specify its size.[^1]

**Syntax:**

```java
arrayName = new dataType[size];
```

**Example:**

```java
// Declaring and then instantiating
int[] numbers;
numbers = new int[10]; // Creates an array to hold 10 integers

// Combining declaration and instantiation
String[] names = new String[5]; // Creates an array to hold 5 Strings
```

When you create an array of a primitive type like `int`, all elements are automatically initialized to their default value (0 for `int`, `false` for `boolean`, etc.). For object types like `String`, they are initialized to `null`.[^1]

***

## 2. Array Literals: A Shortcut

If you know the values of the array elements at the time of declaration, you can use an **array literal** for a more concise syntax. The Java compiler automatically determines the size of the array.[^1]

**Syntax:**

```java
dataType[] arrayName = {value1, value2, value3, ...};
```

**Examples:**

```java
// An array of integers
int[] primeNumbers = {2, 3, 5, 7, 11, 13};

// An array of strings
String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
```


***

## 3. Accessing and Modifying Array Elements

You can interact with individual elements using their **index**. Remember, indices are zero-based, so an array of length 10 has indices from 0 to 9.[^1]

```java
int[] scores = new int[5];

// Assigning values to elements
scores[0] = 95; // First element
scores[1] = 88;
scores[4] = 100; // Last element

// Accessing and printing an element
System.out.println("The first score is: " + scores[0]); // Prints 95

// Modifying an element
scores[1] = 90;
```

Attempting to access an element with an index outside the valid range (e.g., `scores` or `scores[-1]`) will result in an `ArrayIndexOutOfBoundsException` at runtime.

### The `length` Property

Every array has a `length` field that gives you its size. This is a property, not a method, so you access it without parentheses.[^1]

```java
int[] numbers = {10, 20, 30, 40};
System.out.println("The size of the array is: " + numbers.length); // Prints 4
```


***

## 4. Iterating Over Arrays

Looping is the most common way to process all elements in an array.

### A. Using a `for` Loop

The traditional `for` loop gives you control over the index, which is useful when you need to modify elements or know their position.[^1]

```java
String[] fruits = {"Apple", "Banana", "Cherry"};

for (int i = 0; i < fruits.length; i++) {
    System.out.println("Fruit at index " + i + ": " + fruits[i]);
}
```


### B. Using an Enhanced `for` Loop (for-each)

The for-each loop provides a cleaner, more readable syntax when you only need to access each element without worrying about the index. It is less error-prone as there's no index to manage.[^1]

```java
int[] scores = {95, 88, 76, 90};

for (int score : scores) {
    System.out.println("Score: " + score);
}
```

**Note:** You cannot use a for-each loop to modify the array's elements, as it provides you with a copy of the value (for primitives) or the reference, but not the ability to reassign the element at its index.[^1]

***

## 5. Multidimensional Arrays

Java supports multidimensional arrays, which are essentially **arrays of arrays**. A 2D array is the most common, resembling a grid or table with rows and columns.[^1]

### Declaring and Instantiating a 2D Array

```java
// Declaring a 2D array of integers
int[][] matrix;

// Instantiating a 3x4 matrix (3 rows, 4 columns)
matrix = new int[3][4];

// Accessing an element (row 1, column 2)
matrix[1][2] = 7;
```


### Iterating a 2D Array

You use nested loops to iterate through a multidimensional array.[^1]

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

for (int i = 0; i < matrix.length; i++) { // Iterates over rows
    for (int j = 0; j < matrix[i].length; j++) { // Iterates over columns in the current row
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println(); // New line after each row
}
```


***

## 6. Common Array Operations

Since Java arrays are fixed-size, operations like inserting or removing elements require creating a new array or manually shifting elements.

### A. Inserting an Element

To insert an element, you must shift all subsequent elements one position to the right. This will overwrite the last element in the array.[^1]

```java
int[] numbers = {10, 20, 30, 50, 60, 0}; // Room at the end
int insertIndex = 3;
int newValue = 40;

// Shift elements to the right
for (int i = numbers.length - 1; i > insertIndex; i--) {
    numbers[i] = numbers[i - 1];
}

// Insert the new value
numbers[insertIndex] = newValue;
// Array becomes {10, 20, 30, 40, 50, 60}
```


### B. Removing an Element

To remove an element, you shift all subsequent elements one position to the left. This results in the last element being duplicated.[^1]

```java
int[] data = {1, 2, 3, 4, 5};
int removeIndex = 2; // Remove the element '3'

for (int i = removeIndex; i < data.length - 1; i++) {
    data[i] = data[i + 1];
}
// Array becomes {1, 2, 4, 5, 5}
```

**Note**: For dynamic collections that can grow and shrink, it is highly recommended to use `ArrayList` from the Java Collections Framework.

***

## 7. The `java.util.Arrays` Utility Class

Java provides a powerful helper class, `java.util.Arrays`, filled with static methods to perform common array manipulations easily. You must import it using `import java.util.Arrays;`.[^1]


| Method                                            | Description                                                                                                                                            | Example                                             |
|:--------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------|:----------------------------------------------------|
| **`toString(array)`**                             | Returns a string representation of the array's contents. Extremely useful for printing and debugging[^1].                                              | `System.out.println(Arrays.toString(myArray));`     |
| **`sort(array)`**                                 | Sorts the array in ascending order (in-place)[^1].                                                                                                     | `Arrays.sort(myArray);`                             |
| **`equals(array1, array2)`**                      | Returns `true` if both arrays have the same elements in the same order[^1].                                                                            | `boolean areEqual = Arrays.equals(arr1, arr2);`     |
| **`fill(array, value)`**                          | Fills all elements of the array with the specified value[^1].                                                                                          | `Arrays.fill(myArray, 0);`                          |
| **`binarySearch(array, key)`**                    | Searches for a specified element in a **sorted** array using the binary search algorithm. Returns the index if found, or a negative number if not[^1]. | `int index = Arrays.binarySearch(sortedArray, 42);` |
| **`copyOf(original, newLength)`**                 | Creates a new array by copying the specified array. It can be truncated or padded with default values if the new length is different[^1].              | `int[] newArr = Arrays.copyOf(oldArr, 10);`         |
| **`copyOfRange(original, startIndex, endIndex)`** | Creates a new array by copying the specified array within specified range of index. endIndex is exclusive[^1].                                         | `int[] newArr = Arrays.copyOfRange(oldArr, 0, 10);` |

### `Arrays` Class Example:

```java
import java.util.Arrays;

public class ArraysUtilDemo {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 9};

        // 1. Print the array
        System.out.println("Original array: " + Arrays.toString(numbers));

        // 2. Sort the array
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        // 3. Search for an element
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("Element 8 is at index: " + index); // Output: 3

        // 4. Fill a part of the array
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 100);
        System.out.println("Filled array: " + Arrays.toString(filledArray));
        
        // 5. Copy range of an array into another array
        int[] filledArray = new int[5];
        filledArray = Arrays.copyOfRange(numbers, 0,5);
        System.out.println("Filled array: " + Arrays.toString(filledArray));
    }
}
```

***

## 8. Sorting Arrays of Object

Use the below code to sort any custom object or any other class object.


### `Arrays` Class Example:

```java
import java.util.Arrays;

private static class Employee{
    public String name;
    public int    employeeId;

    public Employee(String name, int employeeId){
        this.name       = name;
        this.employeeId = employeeId;
    }
}
public class ArraysUtilDemo {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[3];

        employeeArray[0] = new Employee("Xander", 1);
        employeeArray[1] = new Employee("John"  , 3);
        employeeArray[2] = new Employee("Anna"  , 2);

        java.util.Arrays.sort(employeeArray, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.name.compareTo(e2.name);
            }
        });
        
        for(int i=0; i < employeeArray.length; i++) {
            System.out.println(employeeArray[i].name);
        }
    }
}
```

***

## 8. Practice \& Quiz

### Practice

1. Create an array of your 5 favorite foods (as `String`s). Use a `for-each` loop to print them out.
2. Create an integer array of size 10. Use a `for` loop to fill it with the first 10 even numbers (2, 4, 6, ...). Then, print the array using `Arrays.toString()`.
3. Write a program to find the minimum and maximum value in an integer array without using `Arrays.sort()`.

### Quiz

1. What is the main difference between an `Array` and an `ArrayList` in Java?
2. If an array is declared as `int[] arr = new int;`, what is the valid range of indices?
3. What happens if you try to change the size of an array after creating it?
4. Why is it mandatory for an array to be sorted before using `Arrays.binarySearch()`?
5. How do you declare a 2D array with 5 rows and 3 columns?

<div style="text-align: center">⁂</div>

[^1]: https://jenkov.com/tutorials/java/arrays.html

