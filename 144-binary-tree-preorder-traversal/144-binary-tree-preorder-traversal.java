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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            result.add(curr.val);
            if(null != curr.right) {
                stack.push(curr.right);
            }
            if(null != curr.left) {
                stack.push(curr.left);
            }  
            
            
        }
        return result;
    }
}