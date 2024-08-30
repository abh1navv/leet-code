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
            //System.out.println(curr.val+":"+counter);
            ListNode next = curr.next;
            //if(counter%2==0) {
                //System.out.println(next.val);
                curr.next=curr.next.next;
                tail.next = next;
                tail=next;
            //}
            
            curr=curr.next;
        }
        tail.next=evenHead;
        
        return head;
    }
}