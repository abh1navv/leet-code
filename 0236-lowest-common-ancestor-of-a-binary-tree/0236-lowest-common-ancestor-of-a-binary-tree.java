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
        List<TreeNode> list1=new ArrayList<>();
        dfs(root, p, list1);
        
        List<TreeNode> list2=new ArrayList<>();
        dfs(root, q, list2);
        
        TreeNode ans=null;
        for(int i=Math.min(list1.size(), list2.size())-1; i>=0 ;i--) {
            if(list1.get(i).equals(list2.get(i))) {
                return list1.get(i);
            }
        }
        
        return ans;
    }
    
    boolean dfs(TreeNode root, TreeNode node, List<TreeNode> list) {
        if(root == node) {
            list.add(root);
            return true;
        }
        list.add(root);
        if(null != root.left && dfs(root.left, node, list)) return true;
        if(null != root.right && dfs(root.right, node, list)) return true;
        list.remove(root);
        return false;
    }
}