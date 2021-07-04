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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        int pos = 0;
        int len = 0;
        
        while(head!=null) {
            len++;
            if(visited.contains(head)) return true;
            visited.add(head);
            head = head.next;
        }
        
        return false;
    }
}