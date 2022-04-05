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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> preOrderP = new ArrayList<>();
        getPath(root, p, preOrderP);
        List<TreeNode> preOrderQ = new ArrayList<>();
        getPath(root, q, preOrderQ);
        
        return findFirstCommon(preOrderP, preOrderQ);
    }
    
    public void getPath(TreeNode root, TreeNode p, List<TreeNode> ans) {
        ans.add(root);
        if(root == p) {
            return;
        }
        
        if(root.val > p.val) {
            getPath(root.left, p, ans);
        } else {
            getPath(root.right, p, ans);
        }
    }
    
    TreeNode findFirstCommon(List<TreeNode> first, List<TreeNode> second) {
        int count=0;
        while(count<first.size()&&count<second.size()&&first.get(count).val == second.get(count).val) count++;
        
        return first.get(count-1);
    }
}