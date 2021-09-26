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
    //find length
    //traverse and stop
    //unlink and link back
    if(head == null || k == 0 || head.next == null) {
        return head
    }
    
    const first = head
    const len = findLength(head)
    let rotationPoint = len - k%len
    
    if(rotationPoint == len) return head
    console.log(rotationPoint)
    
    let headNext = head.next
    
    while(head != null && rotationPoint != 1) {
        rotationPoint--
        head = head.next
        headNext = head.next
    }
    
    const finalHead = headNext
    head.next = null
    
    while(headNext != null && headNext.next != null) {
        headNext = headNext.next
    }
    headNext.next = first
    
    return finalHead
}

const findLength = function(head) {
    let n = 0
    while(head != null) {
        n++
        head = head.next
    }
    return n
}