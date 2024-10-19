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
        ListNode temp = head;
        int len = 0;
        while(temp!=null) {
            len++;
            temp = temp.next;
        }
        
        int count = len-n;
        
        if(count < 0) return null;
        else if(count==0 && len==n) return head.next;
        
        temp = head;
        count--;
        while(count>0) {
            count--;
            temp = temp.next;
        }
        if(null != temp && null != temp.next) {
            temp.next = temp.next.next;
        }
        
        return head;
    }
}