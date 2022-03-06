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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            TreeNode dummy = new TreeNode(root.val);
            dummy.left = root;
            rotateNode(dummy, root, false);
            return dummy.left;
        }
        
        findNode(root, key);
        return root;
    }
    
    public void findNode(TreeNode root, int key) {
        if(root == null) return;
        
        if(root.val < key) {
            if(root.right != null && root.right.val == key) {
                rotateNode(root, root.right, true);
                return;
            }
            findNode(root.right, key);
        } else if(root.val > key) {
            if(root.left !=null && root.left.val == key) {
                rotateNode(root, root.left, false);
                return;
            } 
            findNode(root.left, key);
        } 
    }
    
    
    public void rotateNode(TreeNode parent, TreeNode current, boolean isRight) {
        if(isRight) {
            if(current.left == null && current.right == null) parent.right = null;
            else if (current.left == null) parent.right = current.right;
            else if (current.right == null) parent.right = current.left;
            else {
                parent.right = current.right;
                addToLeft(current.left, current.right);
            }
        } else {
            if(current.left == null && current.right == null) parent.left = null;
            else if (current.left == null) parent.left = current.right;
            else if (current.right == null) parent.left = current.left;
            else {
                parent.left = current.right;
                addToLeft(current.left, current.right);
            }
        }
    }
    
    void addToLeft(TreeNode left, TreeNode right) {
        while(right.left != null) right = right.left;
        right.left = left;
    }
    
}