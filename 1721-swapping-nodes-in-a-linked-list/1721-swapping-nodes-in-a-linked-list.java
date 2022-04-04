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
    public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode kth = null;
        ListNode ans = head;
        while(head!=null) {
            count++;
            if(count == k) {
                kth = head;
            }
            head = head.next;
        }
        
        ListNode reverseNode = null;
        k=count-k+1;
        count=0;
        head=ans;
        while(head!=null) {
            count++;
            if(count == k) {
                reverseNode = head;
                break;
            }
            head = head.next;
        }
        
        int temp = kth.val;
        kth.val = reverseNode.val;
        reverseNode.val = temp;
        
        return ans;
    }
}