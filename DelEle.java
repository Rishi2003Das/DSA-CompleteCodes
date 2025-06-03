import java.util.*;
class DelEle{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m;
        do{
        System.out.println("Enter the size of the square matrix");
        m=sc.nextInt();
        }while(m<2 || m>=10);
        int a[];
        a=new int[m];
        for(int i=0;i<m;i++){
            System.out.println("Enter the array elements:");
            a[i]=sc.nextInt();
        }
        System.out.println("Enter the array element to be deleted");
        int s=sc.nextInt();
        int c=0;
        for(int i=0;i<m;i++){
            if(a[i]==s){
            a[i]=0;
            c=i;
            }   
        }
    }
}