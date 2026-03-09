/*

1980. Unique Binary String:
Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.
Example 1:
Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
Example 2:
Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.

*/

class Solution {
    int n;
    Set<String> numsSet = new HashSet();
    
    private String generate(String curr) {
        if (curr.length() == n) {
            if (!numsSet.contains(curr)) {
                return curr;
            }
            
            return "";
        }
        
        String addZero = generate(curr + "0");
        if (addZero.length() > 0) {
            return addZero;
        }
        
        return generate(curr + "1");
    }
    
    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        for (String s : nums) {
            numsSet.add(s);
        }
        
        return generate("");
    }
}
