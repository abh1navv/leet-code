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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>(n);
            
            while(n>0) {
                TreeNode element = queue.remove(0);
                if(element!=null) {
                    queue.add(element.left);
                    queue.add(element.right);
                    list.add(element.val);
                }
                n--;
            }
            if(!list.isEmpty())
                ans.add(list);
        }
        return ans;
        
    }
}