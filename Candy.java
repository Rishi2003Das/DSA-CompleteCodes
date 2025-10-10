// Exclusive Intuitive Slope method!
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1) return n;

        int candies = 1;   
        int up = 0, down = 0, peak = 0;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 0;
                candies += 1 + up;
            } else if (ratings[i] == ratings[i - 1]) {
                up = down = peak = 0;
                candies += 1;
            } else { 
                up = 0;
                down++;
                candies += 1 + down - (peak >= down ? 1 : 0);
            }
        }

        return candies;
    }
}
