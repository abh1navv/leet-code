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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        var ans = list1;
        ListNode first = null, second=null;
        int count = 0;
        while(list1 != null) {
            if(count+1 == a) {
                first = list1;
            }
            if(count == b) {
                second = list1.next;
                break;
            }
            count++;
            list1 = list1.next;
        }
        
        first.next = list2;
        while(list2.next != null) {
            list2 = list2.next;
        }
        list2.next = second;
        
        return ans;
    }
}