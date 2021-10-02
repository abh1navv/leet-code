/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
const getMinimumDifference = function(root) {
    let prev = Number.NEGATIVE_INFINITY, 
        minDiff = Number.POSITIVE_INFINITY
    
    const inorder = function(root) {
        if(root === null) {
            return;
        } 
        inorder(root.left)
        
        minDiff = Math.min(minDiff, root.val - prev)
        prev = root.val
        
        inorder(root.right)
    }
    
    inorder(root)
    return minDiff
}
