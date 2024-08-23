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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        var first = head;
        while(head.next != null) {
            insertGCD(head, head.next);
            head = head.next.next;
        }
        
        return first;
    }
    
    public void insertGCD(ListNode head, ListNode  next) {
        int gcd = calculateGCD(head.val, next.val);
        var gcdNode = new ListNode(gcd, next);
        head.next = gcdNode;
    }
    
    public int calculateGCD(int a, int b) {
        for(int i=Math.min(a, b); i>=1; i--) {
            if(a%i ==0 && b%i ==0) {
                return i;
            }
        }
        
        return 1;
    }
}