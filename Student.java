import java.util.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
class Student {
    String name;
    int rollNumber;
    LocalDate birthday;
    LocalDate admissionDate;
    public Student(String name, int rollNumber, LocalDate birthday, LocalDate admissionDate) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.birthday = birthday;
        this.admissionDate = admissionDate;
    }
    public int getAgeAtAdmission() {
        Period age = Period.between(birthday, admissionDate);
        return age.getYears();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Enter the details for student %d:\n", i + 1);
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Roll number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Birthday (dd/MM/yyyy): ");
            LocalDate birthday = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.print("Admission date (dd/MM/yyyy): ");
            LocalDate admissionDate = LocalDate.parse(scanner.nextLine(), formatter);
            students[i] = new Student(name, rollNumber, birthday, admissionDate);
            System.out.printf("Age at admission: %d\n", students[i].getAgeAtAdmission());
        }
    }
}