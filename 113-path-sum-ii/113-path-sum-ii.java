/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new LinkedList<>();
        getPaths(root, targetSum, paths, new LinkedList<>(), 0);
        return paths;
    }
    
    public void getPaths(TreeNode root, int target, List<List<Integer>> paths, List<Integer> current, int sum) {
        if(root == null) return;
        sum += root.val;
        current.add(root.val);
        if(sum == target && root.left == null && root.right == null) {
            paths.add(new LinkedList<>(current));
        } else {
            getPaths(root.left, target, paths, current, sum);
            getPaths(root.right, target, paths, current, sum);
        }
        current.remove(current.size()-1);
    }
}