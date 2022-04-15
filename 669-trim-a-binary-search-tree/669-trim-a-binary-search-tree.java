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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        trimSubBST(dummy, low, high);
        
        return dummy.left;
    }
    
    void trimSubBST(TreeNode root, int low, int high) {        
        
        if(root.left != null && root.left.val < low) {
            root.left = root.left.right;
            trimSubBST(root, low, high);
        }
        if(root.left != null && root.left.val > high) {
            root.left = root.left.left;
            trimSubBST(root, low, high);
        }
        if(root.right != null && root.right.val > high) {
            root.right = root.right.left;
            trimSubBST(root, low, high);
        }
        if(root.right != null && root.right.val < low) {
            root.right = root.right.right;
            trimSubBST(root, low, high);
        }
        
        if(root.left != null) {
            trimSubBST(root.left, low, high);
        } 
        
        if(root.right != null) {
            trimSubBST(root.right, low, high);
        } 
        

    }
}