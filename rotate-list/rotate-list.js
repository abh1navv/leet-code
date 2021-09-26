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
    let finalHead = head
    
    //find length
    let len = findLength(head)
    
    k = k % len
    
    //empty list or no rotation required
    if(head === null || head.next === null || k === 0) {
        return head
    }
    
    /*  
        linking remains the same for elements to the right and to the left of (len-k)th element
        break the link between the (len-k)th element and the previous element 
        (len-k)th element is the final head after rotation
    */
    while(head.next !== null) {
        if(len - k !== 1) { 
            head = head.next
        } else { 
            let headNext = head.next
            head.next = null
            finalHead = headNext 
            head = headNext
        }  
        len--
    }
    head.next = first //put the first len-k-1 elements at the end
    
    return finalHead
}

const findLength = function(head) {
    let n = 0
    while(head !== null) {
        head = head.next
        n++
    }
    return n
}
