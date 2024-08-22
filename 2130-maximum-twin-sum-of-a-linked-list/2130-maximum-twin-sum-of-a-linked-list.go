/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func pairSum(head *ListNode) int {
    var copyHead = &ListNode{0, nil}
    first:= head
    
    for head != nil {
        var elem = &ListNode{head.Val, nil}
        elem.Next = copyHead
        copyHead = elem
        head = head.Next
    }

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