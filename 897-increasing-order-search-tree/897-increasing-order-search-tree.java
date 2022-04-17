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
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        getInOrder(root, stack);

        TreeNode prev = stack.pop();
        TreeNode ans = prev;
        while(!stack.isEmpty() && prev!=null) {
            TreeNode curr = stack.pop();
            prev.right = curr;
            prev = curr;
            prev.left = null;
            prev.right = null;

        }
        return ans;
    }
    
    void getInOrder(TreeNode root, Stack<TreeNode> stack) {
        if(root == null) return;
        getInOrder(root.right, stack);
        stack.push(root);
        getInOrder(root.left, stack);
    }
}