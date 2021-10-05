/**
 * // Definition for a Node.
 * function Node(val, left, right, next) {
 *    this.val = val === undefined ? null : val;
 *    this.left = left === undefined ? null : left;
 *    this.right = right === undefined ? null : right;
 *    this.next = next === undefined ? null : next;
 * };
 */

/**
 * @param {Node} root
 * @return {Node}
 */
const connect = function(root) {
        
    let head = root
    
    while(head !== null && head.left !== null) {
        let temp = head
        while(temp !=null) {
            temp.left.next = temp.right
            if(null !== temp.next) {
                temp.right.next = temp.next.left
            }
            temp = temp.next
        }
        head = head.left
    }
    return root
}

