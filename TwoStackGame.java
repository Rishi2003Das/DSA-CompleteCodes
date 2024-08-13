import java.util.*;
class TwoStackGame{
    static int twoStacks(int x, int a[], int b[]){
        return twoStacks(x,a,b,0,0) -1;
    }
    
    public static int twoStacks(int x, int a[], int b[], int sum, int count){
        if(sum>x){
            return count;
        }
        
        if(a.length == 0 || b.length == 0)
        return count;
        
        int a1=twoStacks(x, Arrays.copyOfRange(a,1,a.length), b, sum+a[0], count+1);
        int a2=twoStacks(x, a, Arrays.copyOfRange(b,1,b.length), sum+b[0], count+1);
        
        return Math.max(a1,a2);
    }
}
