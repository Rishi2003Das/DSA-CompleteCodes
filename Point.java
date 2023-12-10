//Assignment 19
public class Point{
    protected double x;//Instance variables
    protected double y;
    protected Point(){//Default Parameter
    x=0;//Initialysation of instance variables
    y=0;
    }//end of Point()
    protected Point(double x,double y){
        this.x=x;
        this.y=y;
    }//end of Point(double,double)
    protected void disp(){
        System.out.println("The coordinate of the point in the XY plane is ( "+x+" , "+y+")");
    }//end of disp()
}//end of class
