/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return findNode(cloned, target);
    }
    
    public TreeNode findNode(final TreeNode cloned, final TreeNode target) {
        if(cloned == null) return null;
        if(cloned.val == target.val) return cloned;
        
        TreeNode left = findNode(cloned.left, target);
        if(left != null) return left;

        TreeNode right = findNode(cloned.right, target);
        return right;        
    }
}