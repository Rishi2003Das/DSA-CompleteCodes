import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int ans[]=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
    // remove indices that are out of bound
    while (dq.size() > 0 && dq.peekFirst() <= i - k) {
      dq.pollFirst();
    }
    // remove indices whose corresponding values are less than nums[i]
    while (dq.size() > 0 && nums[dq.peekLast()] < nums[i]) {
      dq.pollLast();
    }
    // add nums[i]
    dq.offerLast(i);
    // add to result
    if (i >= k - 1) {
      ans[i - k + 1] = nums[dq.peekFirst()];
    }
  }
  return ans;
}
}
