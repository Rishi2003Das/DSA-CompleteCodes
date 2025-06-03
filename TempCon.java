//Question9
import java.util.*;
class TempCon{
    public static void main(String args[]){
        int f;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the temperature in farenheit scale");
        f=sc.nextInt();
        int c=((5*(f-32))/9);
        System.out.println("Temperature in Farenheit scale: "+(c));
    }
}