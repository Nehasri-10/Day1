import java.util.Scanner;

public class Calculator {
    public static double add(double a,double b) {
        return a+b;
    }
    public static double subtract(double a,double b) {
        return a-b;
    }
    public static double multiply(double a,double b) {
        return a*b;
    }
    public static double divide(double a,double b) {
        return a/b;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean run=true;
        while (run) {
            System.out.println("\nSimple Calculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice=sc.nextInt();
            if (choice == 5) {
                run=false;
                System.out.println("Exiting the calculator.");
                break;
            }
            System.out.print("Enter num1: ");
            double num1=sc.nextDouble();
            System.out.print("Enter the num2: ");
            double num2=sc.nextDouble();
            double result;
            switch (choice) {
                case 1:
                    result=add(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result=subtract(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result=multiply(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    result=divide(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        }
        sc.close();
    }
}
