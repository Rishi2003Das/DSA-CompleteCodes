package Inheritance;
class D2Point{
    double x;
    double y;
    D2Point(){
        x=y=0.0;
    }
    D2Point(double nx, double ny){
        x=nx;
        y=ny;
    }
    double dist2D(D2Point b){
        return Math.sqrt(Math.pow((b.x-this.x),2)+ Math.pow((b.y-this.y),2));
    }
}