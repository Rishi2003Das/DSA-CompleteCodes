import java.util.*;
class Stringbuilder{
    public static void main(String args[]){
        StringBuilder sb= new StringBuilder("Captain Marvel");
        System.out.println(sb);
        sb.setCharAt(7,'&');
        System.out.println(sb);
        sb.insert(0,'F');
        System.out.println(sb);
        sb.insert(4,'M');
        System.out.println(sb);
        sb.delete(0,2);
        System.out.println(sb);
        sb.append(" IS A SUPER HERO");
        System.out.println(sb);
        int n=sb.length();
        System.out.println("Length of the string= "+n);
}
}