//Subclass of the Library superclass
package Inheritance;
class Compute extends Library{
    private int d;
    private double f;
    Compute(String n, String a, int x, int day){
        super(n,a,x);// Getting the variables from the parent class
        d=day;
    }//end of constructor method
    void fine(){
        if(d>17)
           f= (2.0*5)+(3.0*5)+((d-17)*5.0);
        else if(d>12)
        f =(2.0*5)+((d-12)*3.0);
        else if (d>7)
         f=2.0*(d-7);// Calculating the fine on the books
    }//end of fine()
    void display()
    {
        super.show();
        System.out.println("Days= "+d);
        System.out.println("Total amount= Rs."+((0.02*super.p*d)+f));
    }//end of display()
}//end of class
