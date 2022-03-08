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
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        
        else if(root.left == null) return false;
        
        return preOrder(root.left, true).equals(preOrder(root.right, false));
    }
    
    public String preOrder(TreeNode root, boolean isLeft) {
        if(root == null) return null;
        
        if(isLeft) {
            return root.val + preOrder(root.left, isLeft) + preOrder(root.right, isLeft);
        } else {
            return root.val + preOrder(root.right, isLeft) + preOrder(root.left, isLeft);
        }
    }
}