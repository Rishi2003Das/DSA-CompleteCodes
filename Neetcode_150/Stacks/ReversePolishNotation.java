/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<tokens.length;i++){
            if(tokens[i].equals("+")){
            st.push(st.pop()+st.pop());
            }
            else if(tokens[i].equals("-")){
            int ans=-st.pop()+st.pop();
            st.push(ans);
            }
            else if(tokens[i].equals("*")){
            st.push(st.pop()*st.pop());
            }
            else if(tokens[i].equals("/")){
                int denom=st.pop();
                int ans=st.pop()/denom;
                st.push(ans);
            }
            else{
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.peek();
    }
}
