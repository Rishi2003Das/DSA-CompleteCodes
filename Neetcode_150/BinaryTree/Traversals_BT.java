/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Pair {
    TreeNode node;
    int state;

    Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

class Solution {
    List<List<Integer>> treeTraversal(TreeNode root) {

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            ans.add(preorder);
            ans.add(inorder);
            ans.add(postorder);
            return ans;
        }

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {

            Pair curr = st.pop();

            if (curr.state == 1) {

                preorder.add(curr.node.data);

                curr.state = 2;
                st.push(curr);

                if (curr.node.left != null) {
                    st.push(new Pair(curr.node.left, 1));
                }

            } else if (curr.state == 2) {

                inorder.add(curr.node.data);

                curr.state = 3;
                st.push(curr);

                if (curr.node.right != null) {
                    st.push(new Pair(curr.node.right, 1));
                }

            } else {

                postorder.add(curr.node.data);
            }
        }

        ans.add(preorder);
        ans.add(inorder);
        ans.add(postorder);

        return ans;
    }
}
