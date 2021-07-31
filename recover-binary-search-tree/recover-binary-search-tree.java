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
    public void recoverTree(TreeNode root) {
        
        if(null == root) return;
       
        recoverTree(root.left);
        recoverTree(root.right);   
        
        TreeNode highestLeft = getHighestChild(root.left);
        TreeNode lowestRight = getLowestChild(root.right);
        
        if(null != highestLeft && root.val < highestLeft.val) {
            int rootVal = root.val;
            root.val = highestLeft.val;
            highestLeft.val = rootVal;
            recoverTree(root);

        }  if (null != lowestRight && root.val > lowestRight.val) {
            int rootVal = root.val;
            root.val = lowestRight.val;
            lowestRight.val = rootVal;
            recoverTree(root);
        }       
        
    }
    
    public TreeNode getHighestChild(TreeNode root) {
        while(root != null && root.right !=null && root.right.val > root.val) root = root.right;
        return root;
    }
    
    public TreeNode getLowestChild(TreeNode root) {
        while(root != null && root.left !=null && root.left.val < root.val) root = root.left;
        return root;
    }
    
    
}