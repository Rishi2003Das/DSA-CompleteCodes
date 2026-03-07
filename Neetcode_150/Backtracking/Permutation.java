/*
46. Permutation with no Duplication:
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   backtrack(list, new ArrayList<>(), nums);
   return list;
    }
private void backtrack(List<List<Integer>> list, List<Integer> ds, int[] nums){
  if(nums.length==ds.size()){
    list.add(new ArrayList<>(ds));
    return;
  }
  else
  {
    for(int i=0;i<nums.length;i++){
      if(ds.contains(nums[i])) continue;
      ds.add(nums[i]);
      backtrack(list,ds,nums);
      ds.remove(ds.size()-1);
    }
  }
}
}
      
