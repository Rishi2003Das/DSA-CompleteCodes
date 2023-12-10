import java.util.*;
class PalindromePattern{
    int m;
    String a[][];
    void accept(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the limit for the pattern:");
        m=sc.nextInt();
        a=new String[m][((m*2)-1)];
        int p=m-1;
        int k=m;
        int c=0;
        for(int i=0;i<((m*2)-1);i++){
            for(int j=0;j<m;j++){
                if(j<p)
                a[j][i]=" ";
                else
                a[j][i]=Integer.toString(k);
        }
        if(p==0){
        p=m;
        k=2;
        c++;
        }
        p--;
        if(c==1)
        k++;
        else
        k--;
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
        PalindromePattern ob=new PalindromePattern();
        ob.accept();
        ob.display();
    }
}