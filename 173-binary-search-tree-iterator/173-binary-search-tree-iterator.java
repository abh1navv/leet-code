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
class BSTIterator {

    List<Integer> values; 
    int pointer;
    public BSTIterator(TreeNode root) {
        values = new ArrayList<>();
        values.add(-1);
        pointer = 0;
        getInOrder(root);
    }
    
    public int next() {
        pointer++;
        return values.get(pointer);
    }
    
    public boolean hasNext() {
        return pointer < values.size()-1;
    }
    
    void getInOrder(TreeNode root) {
        if(root == null) return;
        getInOrder(root.left);
        values.add(root.val);
        getInOrder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */