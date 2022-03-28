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
    List<Integer> inOrder = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        getInOrder(root);
        return inOrder.get(k-1);
    }
    
    public void getInOrder(TreeNode root) {
        if(root == null) return;
        
        getInOrder(root.left);
        inOrder.add(root.val);
        getInOrder(root.right);
    }
}