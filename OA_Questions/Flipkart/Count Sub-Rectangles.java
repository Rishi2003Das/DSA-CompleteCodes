import java.util.*;

public class Solution {
    public long countRectangle(long L, long W) {
        long ans=(L*(L+1))/2 * (W*(W+1))/2;
        return ans;
    }
}
