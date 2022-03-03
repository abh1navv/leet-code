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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode root, int prevSum) {
        prevSum*=10;
        int left = 0, right = 0;
        if(root.left == null && root.right == null) return root.val + prevSum;
        if(root.left != null) left = dfs(root.left, (prevSum + root.val));
        if(root.right !=null) right = dfs(root.right, (prevSum + root.val));
        
        return left+right;
    }
}