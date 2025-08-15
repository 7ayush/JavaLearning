import java.util.Scanner;

public class DataTypesDemo {

    public static void main(String[] args) {
        // 👇 Primitive Data Types
        int age = 24;
        double height = 5.9;
        boolean isJavaFun = true;
        char initial = 'A';

        // 👇 Non-primitive Type
        String name = "Ayush";

        // 👇 Output the values
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Java is fun? " + isJavaFun);
        System.out.println("Initial: " + initial);

        // 👇 Type promotion in action
        int x = 7;
        double y = 2.0;
        double result = x + y; // x promoted to double
        System.out.println("x + y = " + result); // Should print 9.0

        // 👇 Integer division vs. decimal division
        System.out.println("7 / 2 (int): " + (7 / 2));        // 3
        System.out.println("7 / 2.0 (mixed): " + (7 / 2.0));  // teractive Trivia ---
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n🧠 Trivia Time!");

        // Question 1
        System.out.print("Q1: What type does this produce? 5 + 2.0 → ");
        String q1 = scanner.nextLine();
        if (q1.equalsIgnoreCase("double")) {
            System.out.println("✅ Correct!");
        } else {
            System.out.println("❌ Nope! It's a double.");
        }

        // Question 2
        System.out.print("Q2: Can a variable name start with an underscore? (yes/no) → ");
        String q2 = scanner.nextLine();
        if (q2.equalsIgnoreCase("yes")) {
            System.out.println("✅ Correct!");
        } else {
            System.out.println("❌ It can! '_score' is valid.");
        }

        // Question 3
        System.out.print("Q3: Is 'class' a valid variable name? → ");
        String q3 = scanner.nextLine();
        if (q3.equalsIgnoreCase("no")) {
            System.out.println("✅ Corre");
        } else {
            System.out.println("❌ 'class' is a reserved keyword.");
        }

        scanner.close();

        // End of program
        System.out.println("\n🎉 You just revised Java data types like a pro!");
    }
}

