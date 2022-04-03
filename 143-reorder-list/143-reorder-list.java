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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        if(fast ==null) return;
        
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //System.out.println(slow.val);
        
        ListNode second = reverseList(slow.next);

        slow.next = null;
        slow = head;
        
        while(slow !=null && second !=null) {
            ListNode slowNext = slow.next;
            ListNode secondNext = second.next;
            slow.next = second;
            second.next = slowNext;
            second = secondNext;
            slow = slowNext;
        }
    }
    
    ListNode reverseList(ListNode start) {
        ListNode curr = start.next, prev=start;
        while(curr!=null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        start.next=null;
        return prev;
    }
}