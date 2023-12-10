package Inheritance;
class D3P extends D2Point{
    double z;
    D3P(){
        super();
        z=0.0;
    }
    D3P(double x, double y, double z){
        super(x,y);
        this.z=z;
    }
    double distance3D(D3P b){
        double k=super.dist2D(b);
        double z=k*k;
        return Math.sqrt(z+Math.pow((b.z-this.z),2));
    }
}