class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;
        int sum = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left]; // Update the left max
                } else {
                    sum += left_max - height[left]; // Calculate trapped water at left
                }
                left++; // Move left pointer rightward
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right]; // Update the right max
                } else {
                    sum += right_max - height[right]; // Calculate trapped water at right
                }
                right--; // Move right pointer leftward
            }
        }
        
        return sum;
    }
}
