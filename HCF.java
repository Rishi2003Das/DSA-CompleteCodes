package Recursion;
class HCF{
    int hcf(int a,int b){
        if(a>b)
        return hcf(a-b,b);
        else if(b>a)
        return hcf(a,b-a);
        else
        return a;
    }
}