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
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        root.val += getSum(root.right, 0);
        getSum(root.left, root.val);

        return root;
    }
    
    public int getSum(TreeNode root, int preSum) {
        if(root == null) return preSum;
        if(root.left == null && root.right==null) {
            root.val += preSum;
            return root.val;
        }

        int right = getSum(root.right, preSum);

        root.val += right;
        int left = getSum(root.left, root.val);
        
        Integer leftMost = null;
        while(root.left !=null) {
            leftMost = root.left.val;
            root = root.left;
        }
        
        return leftMost!=null?leftMost:root.val;
    }
}