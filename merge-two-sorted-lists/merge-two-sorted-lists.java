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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode l3Head = null;

        while(l1!=null || l2!=null) {
            ListNode smaller;
            if(l1 == null) {
                smaller = l2;
                l2 = l2.next;
            }
            else if(l2 == null) {
                smaller = l1;
                l1 = l1.next;
            }
            else if(l1.val < l2.val){
                smaller = l1;
                l1 = l1.next;
            } else {
                smaller = l2;
                l2 = l2.next;
            }
            
            if(root == null) {
                root = smaller;
                l3Head = smaller;
            }
            else {
                l3Head.next = smaller;
                l3Head = l3Head.next;
            }           
        }
        return root;
    }
    
    
}