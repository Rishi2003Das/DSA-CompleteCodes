package Inheritance;
class Marks extends Student{
    int AdmNo;
    int marks;
    String sub;
    Marks(String n, int a, String b, int ad, int m, String s){
        super(n,a,b);
        AdmNo=ad;
        marks=m;
        sub=s;
    }
    char grade(){
        if(marks>=80)
        return 'A';
        else if(marks<80 && marks>=50)
        return 'B';
        else
        return 'C';
    }
    void display(){
        super.display();
        System.out.println("Admission Number: "+AdmNo);
        System.out.println("Marks: "+marks);
        System.out.println("Subject: "+sub);
        System.out.println("Grade Obtained: "+grade());
    }
    public static void main(String args[]){
        Marks ob= new Marks("Rishi",18,"+B",44684,95,"Chemistry");
        ob.grade();
        ob.display();
    }
}