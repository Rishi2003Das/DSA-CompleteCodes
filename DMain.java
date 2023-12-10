package Inheritance;
class DMain{
    public static void main(String args[]){
        D3P ob=new D3P(5.3,8.3,6.4);
        D3P ob1=new D3P(6.3,7.3,4.4);
        System.out.println("Distance in 3D="+ob1.distance3D(ob));
    }
}
