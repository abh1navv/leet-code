/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode bigger, smaller;
        int diff;
        if(lenA > lenB) {
            bigger = headA;
            smaller = headB;
            diff = lenA-lenB;
        } else {
            bigger = headB;
            smaller = headA;
            diff = lenB-lenA;
        }
        
        while(diff!=0) {
            diff--;
            bigger = bigger.next;
        }
        
        while(bigger != smaller) {
            bigger = bigger.next;
            smaller = smaller.next;
            
            if(bigger == null) return null;
        }
        
        return bigger;
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