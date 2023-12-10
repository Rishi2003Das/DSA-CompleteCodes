package Recursion;
// Finding the value of a to the power i by recursive method
class Power{
    private int pow(int a,int i){
        if(i==0)
        return 1;
        else
        return a*pow(a,i-1);
    }
    public static void main(String args[]){
        Power ob=new Power();
        System.out.println("The value of a to the power of i ="+(ob.pow(5,3)));
    }
}