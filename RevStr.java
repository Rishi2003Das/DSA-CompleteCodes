import java.util.*;
class RevStr{
    String s;
    void operate(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string to be reversed: ");
        s=sc.nextLine();
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<(sb.length()/2);i++){
            int front=i;
            int back=sb.length()-1-i;
            char fChar=sb.charAt(front);
            char bChar=sb.charAt(back);
            sb.setCharAt(front,bChar);
            sb.setCharAt(back,fChar);
        }
        System.out.println("Reversed string: "+sb);
    }
    public static void main(String args[]){
        RevStr ob=new RevStr();
        ob.operate();
    }
}