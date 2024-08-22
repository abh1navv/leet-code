/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteMiddle(head *ListNode) *ListNode {
    if(head == nil || head.Next == nil) {
        return head.Next
    }
    
    
    var zero = &ListNode{0, head}
    temp := zero

    ans := head
    for temp != nil && temp.Next !=nil && temp.Next.Next != nil {
        zero = zero.Next
        temp = temp.Next.Next
    }
    
    zero.Next = zero.Next.Next
    
    return ans
}