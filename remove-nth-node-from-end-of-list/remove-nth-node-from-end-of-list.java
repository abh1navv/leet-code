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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //get length of list
        //traverse to len-n
        //remove the next element
        ListNode first = head;
        ListNode removed = head;
        int currCount = 0;
        while(head != null) {
            if(currCount > n) {
                removed = removed.next;
            }
            currCount++;
            head = head.next;
        }
        if(currCount == n) {
            first = first.next;
        }
        if(removed.next !=null) {
            removed.next = removed.next.next;
        } else {
            removed.next = null;
        }
        
        
        return first;
    }
}