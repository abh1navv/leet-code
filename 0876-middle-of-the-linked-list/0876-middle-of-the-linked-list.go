/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func middleNode(head *ListNode) *ListNode {
    temp:= head
    for temp != nil && temp.Next != nil {
        head = head.Next
        temp = temp.Next.Next
    }
    
    return head
}