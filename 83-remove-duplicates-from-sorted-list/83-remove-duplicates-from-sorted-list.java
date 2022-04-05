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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(101);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr!=null && curr.next != null) {
            if(curr.next.val == curr.val) curr.next = curr.next.next;
            else curr = curr.next;
        }
        
        return dummy.next;
    }
}