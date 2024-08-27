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
    public int goodNodes(TreeNode root) {
        return 1 + getNodes(root);
    }
    
    int getNodes(TreeNode root) {
        int count = 0;
        
        if(null == root) return 0;
        
        if(null != root.left && root.left.val >= root.val) count++;
        else if(null != root.left) root.left.val = root.val; 
            
        if(null != root.right && root.right.val >= root.val) count++;
        else if(null != root.right) root.right.val = root.val;
                    
        return count + getNodes(root.right) +  getNodes(root.left);
    }
}