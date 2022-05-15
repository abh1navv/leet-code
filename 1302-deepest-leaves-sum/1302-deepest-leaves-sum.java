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
    int largestKey = 0;
    Map<Integer, Integer> sums = new HashMap<>();

    public int deepestLeavesSum(TreeNode root) {

        fillMap(root, 0);
        return sums.get(largestKey);
    }
    
    public void fillMap(TreeNode root, int level) {
        if(root == null) return;
        if(level >= largestKey) {
            largestKey = level;
            sums.put(level, sums.getOrDefault(level, 0) + root.val);
        }
        
        fillMap(root.left, level+1);
        fillMap(root.right, level+1);
    }
}