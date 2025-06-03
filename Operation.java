class Operation{
public static void calculate(int a, int b) {
    int sum = a + b;
    int product = a * b;
    double division = (double) a / b; // cast to double for floating point division
    int multiplication = a * b;
    System.out.println("Sum: " + sum);
    System.out.println("Product: " + product);
    System.out.println("Division: " + division);
    System.out.println("Multiplication: " + multiplication);
}
}