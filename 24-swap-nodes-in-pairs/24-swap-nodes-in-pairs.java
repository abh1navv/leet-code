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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode next = null;
        int count = 0;

        while (head != null) {
            count++;
            
            // save next
            next = head.next;
            
            // do nothing until count reaches k
            if (count == 2) {
                // reverse the current k-element sub-list and update prev, also reset count
                prev = reverse(prev, head);
                count = 0;
            }
            
            // current pointer moves steadily from head to tail
            head = next;
        }

        return dummy.next;
    }
    
    private ListNode reverse(ListNode prev, ListNode curr) {
        ListNode last = curr.next;
        ListNode first = prev.next;
        ListNode currNext = null;
        curr = first;
        while(curr != last) {
            currNext = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = currNext;
        }
        first.next = last;
        return first;
    }
}