/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                break;
            }
        }
    
        // no cycle if fast pointer reached an end
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // move slow pointer to head and move both pointers at the same pace
        // this will make them meet at the start of the loop
        slow = head;
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow; 
    }
}