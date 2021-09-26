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
    let finalHead
    
    let len = findLength(head)
    k = k % len
    
    if(head == null || k == 0) {
        return head
    }
    
    while(head.next != null) {
        if(len - k != 1) {
            head = head.next
        } else {
            let headNext = head.next
            head.next = null
            finalHead = headNext
            head = headNext
        }  
        len--
    }
    head.next = first
    
    return finalHead
}

const findLength = function(head) {
    let n = 0
    while(head != null) {
        head = head.next
        n++
    }
    return n
}
