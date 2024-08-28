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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        TreeNode[] bfs=new TreeNode[101];
        bfs[0] = root;
        
        int start = 0;
        int end = 0;
        
        while(start<=end && null!=bfs[end]) {
            view.add(bfs[end].val);
            int index = end;
            while(start<=end) {
                if(bfs[start].left!=null) {
                    bfs[++index] = bfs[start].left;
                }
                if(bfs[start].right!=null) {
                    bfs[++index] = bfs[start].right;
                }
                start++;
            }         
            end = index;
        }
        
        return view;
    }
}