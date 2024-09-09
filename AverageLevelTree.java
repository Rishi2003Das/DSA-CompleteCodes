import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class AverageLevelTree {
    
    // Main method to return averages of each level in the binary tree
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> value = levelOrder(root); // Get values level by level
        List<Double> answer = averageOfEachSublist(value); // Calculate averages for each level
        return answer;
    }

    // Method to perform level-order traversal of the binary tree
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> currLevel = new ArrayList<>(level);
            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.poll();
                currLevel.add(curr.val);  // Add int values directly
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result.add(currLevel);
        }
        return result;
    }

    // Method to calculate the average of each sublist (each level in the tree)
    public static List<Double> averageOfEachSublist(List<List<Integer>> nestedList) {
        List<Double> averages = new ArrayList<>();
        for (List<Integer> sublist : nestedList) {
            if (!sublist.isEmpty()) {
                int sum = 0;
                for (Integer num : sublist) {
                    sum += num;
                }
                double avg = (double) sum / sublist.size();
                averages.add(avg);
            } else {
                averages.add(0.0); // In case the sublist is empty
            }
        }
        return averages;
    }

    public static void main(String[] args) {
        // Sample tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();
        List<Double> averages = sol.averageOfLevels(root);
        
        System.out.println(averages);  // Output: [3.0, 14.5, 11.0]
    }
}
