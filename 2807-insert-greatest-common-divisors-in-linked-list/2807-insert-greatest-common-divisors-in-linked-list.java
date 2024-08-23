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
        int gcd = findGcd(head.val, next.val);
        var gcdNode = new ListNode(gcd, next);
        head.next = gcdNode;
    }
    
    int findGcd(int a, int b) {
        while(a > 0 && b > 0) {
            if(a > b) {
                a = a % b;
            }
            else {
                b = b % a; 
            }
        }

        if(a == 0) {
            return b;
        }
        return a;
    }
}