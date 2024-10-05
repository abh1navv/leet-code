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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isRight = true;
        
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            
            while(len != 0) {
                len--;
                TreeNode next = queue.poll();
                if(null != next.left) {
                    queue.add(next.left);
                }
                
                if(null != next.right) {
                    queue.add(next.right);
                }
                
                level.add(next.val);
            }
            
            if(isRight) {
                ans.add(level);
            } else {
                Collections.reverse(level);
                ans.add(level);
            }
            
            isRight = !isRight;
        }
        
        return ans;
    }
}