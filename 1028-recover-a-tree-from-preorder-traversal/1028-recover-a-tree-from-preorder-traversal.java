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
    int index = 1;
    public TreeNode recoverFromPreorder(String traversal) {
        int index = 0;
        int num = 0;
        int len = traversal.length();

        while(index<len && traversal.charAt(index) != '-') {
            num = num*10+traversal.charAt(index++)-48;
        }
        TreeNode root = new TreeNode(num);
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        TreeNode current;
        int depth = 1, newDepth;
        
        while(index != len && !stack.isEmpty()) {
                        
            current = stack.peek();
            newDepth = 0;
            
            while(traversal.charAt(index) == '-') {
                newDepth++;
                index++;
            }
            
            if(newDepth == depth) {
                if(current.left != null) {
                    num = 0;
                    while(index<len && traversal.charAt(index) != '-') {
                        num = num*10+traversal.charAt(index++)-48;
                    }
                    current.right = new TreeNode(num);
                    stack.push(current.right);
                    depth++;
                } else {
                    num = 0;
                    while(index<len && traversal.charAt(index) != '-') {
                        num = num*10+traversal.charAt(index++)-48;
                    }
                    current.left = new TreeNode(num); 
                    stack.push(current.left);
                    depth++;
                }
            } else if(newDepth < depth) {
                stack.pop();
                index-=newDepth;
                depth--;
            }
        }
        
        return root;
    }
    
    
}