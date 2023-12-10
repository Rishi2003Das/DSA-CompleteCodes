package Recursion;
class Factorial{
    int fact(int n){
        if(n==1)
        return 1;
        else
        return n*fact(n-1);
    }
    public static void main(String args[]){
        Factorial ob=new Factorial();
        System.out.println(ob.fact(4));
    }
}