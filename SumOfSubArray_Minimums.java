import java.util.Stack;

class Solution {
    private final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        // Arrays to store the index of the previous and next smaller elements
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        // Initialize stacks for calculation
        Stack<Integer> st = new Stack<>();

        // Compute previous smaller for each element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        // Clear the stack to reuse for next smaller calculation
        st.clear();

        // Compute next smaller for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Calculate the sum of subarray minimums
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevSmaller[i]; // Number of elements on the left
            long right = nextSmaller[i] - i; // Number of elements on the right
            ans = (ans + (left * right % MOD) * arr[i] % MOD) % MOD;
        }

        return (int) ans;
    }
}
