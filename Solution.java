import java.util.Scanner;
public class Solution {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int t;
        do{
        // Read the number of test cases
        t = sc.nextInt();
        }while(t<=0 || t>1000);
        for (int i=0; i<t; i++){
            int g;
            do{
            // Read the value of g
            g = sc.nextInt();
            }while(g<=0 || g>Math.pow(10, 9));
            int n;
            do{
            // Read the length of the array
            n = sc.nextInt();
            }while(n<=0 || n>Math.pow(10, 5));
            int[] arr = new int[n];
            for(int j=0;j<n;j++){
                do{
                // Read the elements of the array
                arr[j] = sc.nextInt();
                }while(arr[j]<0 || arr[j]>Math.pow(10, 9));
            }
            int c=0;
            for(int k=0;k<n;k++){
                if(arr[k]>g)
                c++;
            }
            System.out.println(c);
        }
    }
}
