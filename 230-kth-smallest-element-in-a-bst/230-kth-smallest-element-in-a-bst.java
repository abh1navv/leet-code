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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> preOrder = new ArrayList<>();
        getPreOrder(root,preOrder);
        return preOrder.get(k-1);
    }
    
    public void getPreOrder(TreeNode root,List<Integer> list) {
        if(root == null) return;
        
        getPreOrder(root.left, list);
        list.add(root.val);
        getPreOrder(root.right, list);
    }
}