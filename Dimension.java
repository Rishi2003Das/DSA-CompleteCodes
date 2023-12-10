package Inheritance;
//Parent class or super class
import java.util.*;
class Dimension{
    int no_of_sides;
    double sides[];
    double area;
    void calcArea(){
        area=0.0d;
    }
    Dimension(int num){
        no_of_sides=num;
        sides=new double[num];
    }
    void readSides(){
        Scanner sc= new Scanner(System.in);
        for(int i=0;i<no_of_sides;i++){
            System.out.println("Enter side"+(i+1)+" : ");
            sides[i]=sc.nextDouble();
        }
    }
}