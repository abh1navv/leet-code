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
    public void flatten(TreeNode root) {
        LinkedList<TreeNode> stack=new LinkedList<>();
        int top=0;
        
        flattenRoot(stack,root);
        
        Iterator<TreeNode> iterator = stack.iterator();
        if(iterator.hasNext()) {
            iterator.next();
        }
        while(iterator.hasNext()) {
            root.right = iterator.next();
            root.left = null;
            root=root.right;
        }
    }
    
    public void flattenRoot(LinkedList<TreeNode> stack, TreeNode root) {
        if(root==null) 
            return;
        if(root != null) {
            stack.add(root);
        }
        if(root.left != null)
            flattenRoot(stack,root.left);
        if(root.right!=null)
            flattenRoot(stack,root.right);
    }
}