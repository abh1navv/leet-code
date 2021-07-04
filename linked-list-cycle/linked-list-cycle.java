/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode head1 = head;   
        if(head == null) return false;
        while(head.next!=null && head.next.next!=null) {
            head = head.next.next;
            head1 = head1.next;
            if(head == head1) return true;
        }
        
        return false;
    }
}