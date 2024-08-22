/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
    var front *ListNode
    for head != nil {
        next := head.Next
        head.Next = front
        front = head
        head = next
    }
    
    return front
}