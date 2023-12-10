package Inheritance;
class Salary extends Employee{
    double basic;
    double netsal;
    Salary(int eno,String ename, String empdesig, double b){
        super(eno,ename,empdesig);
        basic=b;
        netsal=0.0;
    }
    void calculate(){
        double da=.75*basic;
        double hra=.15*basic;
        double salary=basic+da+hra;
        double pf=.12*salary;
        netsal=salary-pf;
    }
    void display(){
        super.display();
        System.out.println("Net Salary="+netsal);
    }
}