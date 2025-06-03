import java.util.*;
class Marks{
public static void main(String args[]){
        int max,min;int n;
        Scanner sc=new Scanner(System.in);
        do{
         System.out.println("Enter the number of students: ");
         n=sc.nextInt();
        }while(n<0 || n>100);
    int a[] = new int[n];
    min=max=a[0];
     for(int i=0;i<n;i++){
             System.out.println("Enter the array element: ");
             a[i]=sc.nextInt();
         }
         int p=0;
         int f=0;
         int s=0;
    for(int i=0;i<n;++i){
if(a[i]>max)
max=a[i];
if(a[i]<min)
min=a[i];
if(a[i]>50)
p++;
else
f++;
s+=a[i];
}
System.out.println("The least marks is: "+ min );
System.out.println("The highest marks is: "+ max );
System.out.println("The number of students passed are: "+ p);
System.out.println("The number of students failed are: "+ f);
System.out.println("The average marks of the students :"+ (s/n));
}
}