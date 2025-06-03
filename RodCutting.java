//POTD2
import java.io.*;
import java.util.*;
class RodCutting{
    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);
            RodCutting ob = new RodCutting();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
    public int solve(int[] price, int n){
        if(n==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            int cut = price[i-1];
            int rest = solve(price,n-i);   
            max = Math.max(max,cut+rest);
        }
        return max;
    }   
    public int cutRod(int price[], int n) {
        int dp[]=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],price[j-1]+dp[i-j]);
            }
        }
        return dp[n];
    }
}