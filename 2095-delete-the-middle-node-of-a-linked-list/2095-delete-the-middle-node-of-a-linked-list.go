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
    
    
    //var zero = &ListNode{0, head}
    temp := head.Next.Next
    ans := head

    for temp != nil && temp.Next !=nil  {
        head = head.Next
        temp = temp.Next.Next
    }
    
    head.Next = head.Next.Next
    
    return ans
}