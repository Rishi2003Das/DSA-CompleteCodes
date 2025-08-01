class Solution{
    public int[] maxSlidingWindow(int[] nums, int k) {
  // assume nums is not null
  int n = nums.length;
  if (n == 0 || k == 0) {
    return new int[0];
  }
  int[] result = new int[n - k + 1]; // number of windows
  Deque<Integer> win = new ArrayDeque<>(); // stores indices
  
  for (int i = 0; i < n; ++i) {
    while (win.size() > 0 && win.peekFirst() <= i - k) {
      win.pollFirst();
    }
    while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
      win.pollLast();
    }
    win.offerLast(i);
    if (i >= k - 1) {
      result[i - k + 1] = nums[win.peekFirst()];
    }
  }
  return result;
}
}
