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
    public ListNode mergeNodes(ListNode head) {
        var first = head;
        ListNode prev = null;
        var move = head;
        int sum = 0;
        while(move.next != null) {
            move = move.next;

            if(move.val != 0) {
                sum += move.val;
            } else {
                head.val = sum;
                prev = head;
                head = head.next;
                sum = 0;
            }
        }
        prev.next = null;
        return first;
    }
}