package Inheritance;
//Sub-class or daughter class
class Triangle extends Dimension{
    Triangle(){
        super(3);
        System.out.println("-------TRIANGLE---------");
        readSides();
    }
    void calcArea(){
        double s=(sides[0]+sides[1]+sides[2])/2;
        area=Math.sqrt(s*(s-sides[0])*(s-sides[1])*(sides[2]));
    }
    void display(){
        System.out.println("TRIANGLE STATISTICS");
        System.out.println("Side 1: "+sides[0]);
        System.out.println("Side 2: "+sides[1]);
        System.out.println("Side 3: "+sides[2]);
        calcArea();
        System.out.println("Area: "+area);
    }
}