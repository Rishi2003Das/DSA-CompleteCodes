import java.util.*;
class Sen{
    void accept(){
        System.out.println("Enter the String");
        String s=new Scanner(System.in).nextLine();
        StringTokenizer st=new StringTokenizer(s,".?!");
        int l=0;
        String a[]=new String[10];
        while(st.hasMoreTokens()){
            a[l++]=st.nextToken();
        }
        int v[]=new int[l];
        int w[]=new int[l];
        System.out.println("Sentence\tNo. of Vowels\tNo. of Words");
        for(int i=0;i<l;i++){
            v[i]=vowelC(a[i]);
            w[i]=wordC(a[i]);
            System.out.println((i+1)+"\t\t"+v[i]+"\t\t"+w[i]);
        }
        System.out.println("Sentence\tNo. of Vowels\tWords");
        for(int i=0;i<l;i++){
            System.out.println((i+1)+" "+charR('V',(v[i]*3)));
            System.out.println("\t\t"+charR('W',(w[i]*3)));
        }
    }
    String charR(char x,int n){
        String h="";
        for(int i=0;i<n;i++)
        h+=x;
        return h;
    }
    int vowelC(String s){
        String v="AEIOU";
        int c=0;
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(v.indexOf(x)!=-1)
            c++;
        }
        return c;
        }
    int wordC(String s){
        StringTokenizer st=new StringTokenizer(s);
        int c=0;
        String u="";
        while(st.hasMoreTokens()){
            c++;
            u=st.nextToken();
        }
        return c;
    }
    public static void main(String args[]){
        Sen ob=new Sen();
        ob.accept();
    }
}