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
    public boolean isPalindrome(ListNode head) {
        int len = getLength(head);
        int half = len%2==0?len/2-1:len/2;
        
        ListNode curr = head.next;
        ListNode temp;
        ListNode currHead = head;
        while(half!=0) {
            temp = curr.next;
            curr.next = currHead;
            currHead = curr;
            curr = temp;
            half--;
        }
        
        ListNode second = curr;
        if(len%2 == 1) currHead = currHead.next;
        
        while(currHead!=null && second!=null) {    
            if(currHead.val != second.val) return false;
            currHead = currHead.next;
            second = second.next;
        }
                
        return true;
    }
    
    public int getLength(ListNode head) {
        int count = 0;
        while(head!=null) {
            count++;
            head = head.next;
        }
        
        return count;
    }
}