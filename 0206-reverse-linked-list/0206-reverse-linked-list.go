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
        head.Next, front, head = front, head, head.Next
    }
    
    return front
}