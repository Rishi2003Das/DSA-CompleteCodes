class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for(int num : nums){
            if(num < pivot)
                smaller.add(num);
            else if(num == pivot)
                equal.add(num);
            else
                greater.add(num);
        }

        int[] ans = new int[nums.length];
        int idx = 0;

        for(int x : smaller)
            ans[idx++] = x;

        for(int x : equal)
            ans[idx++] = x;

        for(int x : greater)
            ans[idx++] = x;

        return ans;
    }
}
