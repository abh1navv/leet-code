/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
const rotateRight = function(head, k) {
    
    if(head === null) {
        return head
    }
    let len = 1
    let first = head
    
    while(head.next !== null) {
        len++
        head = head.next
    }
    
    //make a circle
    head.next = first
    
    len -= k%len
    while(len > 0) {
        head = head.next
        len--
    }
    
    // save the new head
    first = head.next
    
    //break the circle
    head.next = null
    
    return first
}
