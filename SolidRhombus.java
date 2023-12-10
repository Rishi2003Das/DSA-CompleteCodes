import java.util.*;
class SolidRhombus{
    int m;
    String a[][];
    void accept(){
        Scanner sc=new Scanner(System.in);
        do{
        System.out.println("Enter the size of the square matrix");
        m=sc.nextInt();
    }while(m<2 || m>=100);
    a=new String[m][((m*2)-1)];
    int p=m-1;
    for(int i=0;i<m;i++){
        for(int j=0;j<((m*2)-1);j++){
            if(j<p)
            a[i][j]=" ";
            if(j>=p && j<(p+m))
            a[i][j]="#";
            if(j>=(p+m))
            a[i][j]=" ";
        }
        p--;
    }
}
void display(){
    for(int i=0;i<m;i++){
        for(int j=0;j<((m*2)-1);j++)
            System.out.print(a[i][j]);
            System.out.println();
        }
}
public static void main(String args[]){
    SolidRhombus ob=new SolidRhombus();
    ob.accept();
    ob.display();
}
}