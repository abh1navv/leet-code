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
    public int diameterOfBinaryTree(TreeNode root) { 
        return getDepthAndPath(root)[1];        
    }
    
    public int[] getDepthAndPath(TreeNode root) {
        int[] currMax = new int[2];
        if(root == null) return currMax;
        else {
            int[] left = getDepthAndPath(root.left);
            int[] right = getDepthAndPath(root.right);
            
            currMax[0] = 1 + Math.max(left[0], right[0]); 
            currMax[1] = Math.max(left[0]+right[0], Math.max(left[1],right[1])); 
        }
        
        return currMax;
    }
}