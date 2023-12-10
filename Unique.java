import java.util.*;
class Unique{
    String str;
    Unique(){
        str="";
    }
    void read(){
        System.out.println("Enter a sentence");
        str=new Scanner(System.in).nextLine();
    }
    void showUnique(){
        StringTokenizer st=new StringTokenizer(str);
        int c=st.countTokens();
        int f=1;
        for(int i=1;i<=c;i++){
            String x=st.nextToken();
            for(int j=97;j<=122;j++){
                int c1=0;
                for(int k=0;k<x.length();k++){
                    if(x.charAt(k)==(char)j)
                    c1++;
                }
                if(c1>=2)
                f=0;
            }
            if(f==1)
            System.out.print(x+"");
        }
    }
    public static void main(String args[]){
        Unique ob=new Unique();
        ob.read();
        ob.showUnique();
    }
}