import java.util.*;
class PrimeAdam{
    private int m,n;
    void accept(){
        Scanner sc=new Scanner(System.in);
        do{
        System.out.println("Enter the lower range-");
        m=sc.nextInt();
        System.out.println("Enter the upper range-");
        n=sc.nextInt();
    }while(m<= 0|| n<=0 || m>=n);
        System.out.print("THE PRIME-ADAM INTEGERS ARE:");
        int c=0;
        for(int i=m;i<=n;i++){
            if(isPrime(i))
            if(isAdam(i)){
                System.out.print(i+" ");
                c++;
            }
        }
        System.out.println("\nThe frequency of the Prime-Adam integers are: "+c);
    }
    boolean isPrime(int x){
        if(x==0 || x==1)
        return false;
        for(int i=2;i<=(x/2);i++){
            if(x%i==0)
            return false;
        }
        return true;
    }
    boolean isAdam(int x){
        int k=rev(x);
        int p=x*x;
        int q=k*k;
        if(rev(p)==q)
        return true;
        else
        return false;
    }
    int rev(int n){
        int r=0;
        while(n>0){
            r=r*10+(n%10);
            n/=10;
        }
        return r;
    }
    public static void main(String args[]){
        PrimeAdam ob=new PrimeAdam();
        ob.accept();
    }
}