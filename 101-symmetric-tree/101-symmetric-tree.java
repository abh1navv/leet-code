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
        
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        preOrder(root.left, true, left);
        preOrder(root.right, false, right);
        
        return left.toString().equals(right.toString());
    }
    
    public void preOrder(TreeNode root, boolean isLeft, StringBuilder sb) {
        if(root == null) {
            sb.append("X");
            return;
        }
        if(isLeft) {
            sb.append(root.val);
            preOrder(root.left, isLeft,sb);
            preOrder(root.right, isLeft,sb);
        } else {
            sb.append(root.val);
            preOrder(root.right, isLeft,sb);
            preOrder(root.left, isLeft,sb);
        }
    }
}