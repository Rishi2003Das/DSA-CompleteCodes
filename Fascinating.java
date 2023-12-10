import java.util.*;
class Fascinating{
    int lr;
    int ur;
    Fascinating(int a,int b){
        lr=a;
        ur=b;
    }
    void display(){
        for(int i=lr; i<=ur; i++){
            int b=i*2;
            int c=i*3;
            String k=concatDigit(i)+concatDigit(b)+concatDigit(c);
            if(isUnique(k))
            System.out.print(i+" ");
        }
    }
    String concatDigit(int k){
        return k+"";
    }
    boolean isUnique(String s){
        for(int i=48; i<=57; i++){
            int c=0;
            for(int j=0; j<s.length(); j++){
                if((char)i==s.charAt(j))
                c++;
            }
            if(c>=2)
            return false;
        }
        return true;
    }
    public static void main(String args[]){
        new Fascinating(100,200).display();
    }
}