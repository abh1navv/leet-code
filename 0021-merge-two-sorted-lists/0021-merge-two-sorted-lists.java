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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0, null);
        ListNode ans = head;
        
        
        while(list1 !=null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            
            if(val1 < val2) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head.next.next = null;
            head = head.next;
        }
        
        if(list1 != null) head.next = list1;
        if(list2 != null) head.next = list2;
        
        
        return ans.next;
    }
}