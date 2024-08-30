/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        
        ListNode curr=head.next;
        ListNode evenHead = head.next;
        ListNode tail=head;
        while(curr!=null && curr.next != null) {                 
            ListNode next = curr.next;
            curr.next = next.next;
            tail.next = next;
            tail=next;
            curr=curr.next;
        }
        tail.next=evenHead;
        
        return head;
    }
}