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
    public ListNode reverseList(ListNode head) {
        ListNode root = head;
        while(head!=null && head.next !=null) {
            ListNode headNext = head.next;
            head.next = headNext.next;
            headNext.next = root;
            root = headNext;
        }
        return root;
    }
}