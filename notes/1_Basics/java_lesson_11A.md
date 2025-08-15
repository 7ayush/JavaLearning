## Answers to Practice \& Quiz on Java Arrays

### **Practice Answers**

**1. Create an array of your 5 favorite foods (as `String`s). Use a `for-each` loop to print them out.**

```java
public class FavoriteFoods {
    public static void main(String[] args) {
        // 1. Create the String array using a literal
        String[] favoriteFoods = {"Pizza", "Sushi", "Tacos", "Pasta", "Ice Cream"};

        System.out.println("My favorite foods are:");

        // 2. Use a for-each loop to print each element
        for (String food : favoriteFoods) {
            System.out.println("- " + food);
        }
    }
}
```

**2. Create an integer array of size 10. Use a `for` loop to fill it with the first 10 even numbers (2, 4, 6, ...). Then, print the array using `Arrays.toString()`.**

```java
import java.util.Arrays; // Import the Arrays utility class

public class EvenNumbersArray {
    public static void main(String[] args) {
        // 1. Create an integer array of size 10
        int[] evenNumbers = new int[10];

        // 2. Use a for loop to fill it with even numbers
        // The nth even number is (n+1) * 2
        for (int i = 0; i < evenNumbers.length; i++) {
            evenNumbers[i] = (i + 1) * 2;
        }

        // 3. Print the array using Arrays.toString()
        System.out.println("The first 10 even numbers are: " + Arrays.toString(evenNumbers));
        // Output: The first 10 even numbers are: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
    }
}
```

**3. Write a program to find the minimum and maximum value in an integer array without using `Arrays.sort()`.**

```java
public class FindMinMax {
    public static void main(String[] args) {
        int[] numbers = {45, 12, 89, 2, 55, 99, 34};

        // 1. Assume the first element is both the min and max initially
        int min = numbers[0];
        int max = numbers[0];

        // 2. Loop through the rest of the array (starting from the second element)
        for (int i = 1; i < numbers.length; i++) {
            // 3. Update min if a smaller number is found
            if (numbers[i] < min) {
                min = numbers[i];
            }
            // 4. Update max if a larger number is found
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println("The minimum value in the array is: " + min); // Output: 2
        System.out.println("The maximum value in the array is: " + max); // Output: 99
    }
}
```


***

### **Quiz Answers**

##### **1. What is the main difference between an `Array` and an `ArrayList` in Java?**
The main difference is **size**. An `Array` has a fixed size determined at creation, while an `ArrayList` has a dynamic size that can grow or shrink as you add or remove elements. `ArrayList` is part of the Java Collections Framework and provides more built-in methods for manipulation (`.add()`, `.remove()`, `.size()`, etc.).

##### **2. If an array is declared as `int[] arr = new int;`, what is the valid range of indices?**
The valid range of indices is from **0 to 4**. The first element is at `arr` and the last element is at `arr`. In general, for an array of length `L`, the valid index range is `0` to `L-1`.

##### **3. What happens if you try to change the size of an array after creating it?**
You **cannot** change the size of an array after it has been created. The `length` property of an array is `final`. If you need a larger or smaller array, you must create a new one and copy the elements from the old array to the new one.

##### **4. Why is it mandatory for an array to be sorted before using `Arrays.binarySearch()`?**
The binary search algorithm works by repeatedly dividing the search interval in half. It compares the target value to the middle element of the array. If the values don't match, it eliminates half of the array based on whether the target is greater or less than the middle element. This logic only works if the elements are in a sorted order. On an unsorted array, the results of `binarySearch()` are undefined and will likely be incorrect.

##### **5. How do you declare a 2D array with 5 rows and 3 columns?**
You declare and instantiate it as follows:

```java
int[][] matrix = new int[5][3];
```

This creates a 2D array where `matrix.length` is 5 (the number of rows) and `matrix.length` (and all other `matrix[i].length`) is 3 (the number of columns).

