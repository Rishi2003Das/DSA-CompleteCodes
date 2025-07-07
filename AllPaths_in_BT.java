class Solution {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }

        // Add current node to the path
        path.add(node.val);

        // Check if it's a leaf
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));  // Copy current path to results
        } else {
            // Recurse left and right
            dfs(node.left, path, ans);
            dfs(node.right, path, ans);
        }

        // Backtrack — remove last node before returning
        path.remove(path.size() - 1);
    }
}
