/*
17. Given a string containing digits from 2-9 inclusive, return all possible letter combinations
that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.
*/

//Backtracking solution

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<String>();

         if (digits == null || digits.length() == 0) {
            return ans;
        }
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, 0, map, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String digits, int idx, Map<Character, String> map, StringBuilder str, List<String> ans){
        if( idx == digits.length()){
            ans.add(str.toString());
            return;
        }
        String s=map.get(digits.charAt(idx));
        for(int i=0; i<s.length();i++){
            char c= s.charAt(i);
            str.append(c);
            backtrack(digits,idx+1,map,str,ans);
            str.deleteCharAt(str.length()-1);
        }
    }
}
