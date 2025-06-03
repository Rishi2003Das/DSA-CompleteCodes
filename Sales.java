class Sales {
    private String name;
    private int id;
    private double salary;
    private String department;
    public Sales(String name, int id, double salary, String department) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.department = department;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public double getSalary() {
        return salary;
    }
    public String getDepartment() {
        return department;
    }
    public static void printSalesEmployees(Sales[] employees, int length) {
        for (int i = 0; i < length; i++) {
            if (employees[i].getDepartment().equals("Sales")) {
                System.out.printf("Name: %s, Salary: %.2f\n", employees[i].getName(), employees[i].getSalary());
            }
        }
    }
}

