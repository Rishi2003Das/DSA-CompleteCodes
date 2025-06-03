import java.util.*;
class Worker{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name1;
    double wages1;
    int workingDays1;
    String name2;
    double wages2;
    int workingDays2;
        System.out.println("Enter details of worker 1:");
        System.out.print("Name: ");
        name1 = sc.nextLine();
        System.out.print("Wages: ");
        wages1 = sc.nextDouble();
        System.out.print("Working days: ");
        workingDays1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter details of worker 2:");
        System.out.print("Name: ");
        name2 = sc.nextLine();
        System.out.print("Wages: ");
        wages2 = sc.nextDouble();
        System.out.print("Working days: ");
        workingDays2 = sc.nextInt();
        double totalPayment = wages1 * workingDays1 + wages2 * workingDays2;
        System.out.println("Total payment: " + totalPayment);
    }
}