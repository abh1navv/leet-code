import java.util.Collection;
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
        Set<TreeNode> pathP = new HashSet<>();
        findPath(root, p,new ArrayList<TreeNode>(), pathP);
        List<TreeNode> pathQ = new ArrayList<>();
        findPath(root,  q,new ArrayList<TreeNode>(), pathQ);
         
        for(int i=pathQ.size()-1; i>=0; i--) {
            if(pathP.contains(pathQ.get(i))) {
                return pathQ.get(i);
            }
        }
        
        return root;
        
    }
    
    public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> current, Collection<TreeNode> path) {
        if(root == null) {
            return false;
        }
        current.add(root);

        if(root == target) {
            path.addAll(current);
            return true;
        }
        
        boolean ans = findPath(root.left, target, current, path) || findPath(root.right, target,current, path);
        if(!ans) {
            current.remove(current.size()-1);
        }
        return ans;
    }
}