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
        
    const first = head
    let curr = head
    
    let len = 0
    while(curr != null) {
        len++
        curr = curr.next
    }
    
    let rotationPoint = len - k%len
    
    if(head == null || rotationPoint == len) return head
    
    while(head.next != null && rotationPoint != 1) {
        rotationPoint--
        head = head.next
    }
    
    let headNext = head.next
    head.next = null
        
    const finalHead = headNext
    
    while(headNext.next != null) {
        headNext = headNext.next
    }
    headNext.next = first
    
    return finalHead
}
