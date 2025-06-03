import java.util.*;
class Perfect{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Lower limit: ");
        int l=sc.nextInt();
        System.out.println("Enter the Upper limit: ");
        int u=sc.nextInt();
        int s=0;
        System.out.println("The Perfect Numbers are: ");
        for(int k=l;k<=u;k++){
        for(int i=1;i<=(k/2);i++){
            if(k%i==0){
            s+=i;
            }
        }
        if(s==k)
        System.out.println(k);
    }
}
}