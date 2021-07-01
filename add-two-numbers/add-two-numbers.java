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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem=0;
        int lval1 = 0, lval2 = 0;
        ListNode headSum = null, rootSum = null;
        while(l1 != null || l2 != null) {
            if(l1 !=null){
                lval1 = l1.val;
                l1 = l1.next;
            } else {
                lval1 = 0;
            }
            if(l2 !=null){
                lval2 = l2.val;
                l2 = l2.next;
            } else {
                lval2 = 0;
            }
            int s = lval1 + lval2 + rem;
            int sum = s % 10;
            rem = s/10 ;
            ListNode currSum = new ListNode(sum);
            if(headSum == null) {
                headSum = currSum;
                rootSum = currSum;
            } else {
                headSum.next = currSum;
                headSum = currSum;
            }
            
        }
        if(rem>0) {
            ListNode currSum = new ListNode(rem);
            headSum.next = currSum;    
        }
        
        return rootSum;
    }
}