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
        List<List<Integer>> paths = new ArrayList<>();
        getPaths(root, targetSum, paths, new ArrayList<>());
        return paths;
    }
    
    public void getPaths(TreeNode root, int target, List<List<Integer>> paths, List<Integer> current) {
        if(root == null) return;
        current.add(root.val);
        if(target == root.val && root.left == null && root.right == null) {
            paths.add(new ArrayList<>(current));
        } else {
            getPaths(root.left, target - root.val, paths, current);
            getPaths(root.right, target - root.val, paths, current);
        }
        current.remove(current.size()-1);
    }
}