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
    public int maxLevelSum(TreeNode root) {
        List<TreeNode> queue=  new ArrayList<>();
        queue.add(root);
        int index=0;
        int max=root.val-1;
        int level=1;
        int ans=1;
        
        while(index<queue.size()) {
            int len = queue.size();
            int curr=0;
            while(index<len) {
                TreeNode currNode = queue.get(index++);
                curr+=currNode.val;
                if(currNode.left != null) {
                    queue.add(currNode.left);
                } 
                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
            
            if(curr > max) {
                max=curr;
                ans=level;
                //System.out.println(curr+":"+level);
            }
            level++;
        }
        
        return ans;
    }
}