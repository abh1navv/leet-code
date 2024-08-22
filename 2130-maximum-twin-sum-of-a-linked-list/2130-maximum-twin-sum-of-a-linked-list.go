/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func pairSum(head *ListNode) int {
    temp := head
    first := head
    
    for temp != nil && temp.Next !=nil {
        head = head.Next
        temp = temp.Next.Next
    }
    
    copyHead := reverse(head)

    var max = first.Val + copyHead.Val;
    
    for first.Next != nil && copyHead.Next !=nil {
        first = first.Next
        copyHead = copyHead.Next
        if copyHead.Val + first.Val > max {
            max = copyHead.Val + first.Val
        }
    }
    
    return max;
    
}

func reverse(head *ListNode) *ListNode {
    var prev *ListNode
    curr := head
    for curr != nil {
        next := curr.Next
        curr.Next = prev
        prev = curr
        curr = next
    }
    return prev
}