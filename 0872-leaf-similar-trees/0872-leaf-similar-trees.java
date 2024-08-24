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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstLeaves = new ArrayList<>();
        computeLeaves(firstLeaves, root1);
        
        List<Integer> secondLeaves = new ArrayList<>();
        computeLeaves(secondLeaves, root2);
        
        return firstLeaves.equals(secondLeaves);
    }
    
    void computeLeaves(List<Integer> leaves, TreeNode root) {
        if(root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        computeLeaves(leaves, root.left);        
        computeLeaves(leaves, root.right);
    }
}