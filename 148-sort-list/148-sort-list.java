public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = null, slow = null, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow == null? head : slow.next;
            fast = fast.next.next;
        }
        mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }
  
    ListNode merge(ListNode left, ListNode right) {
        ListNode sorted = new ListNode(0), temp = sorted;

        while (left != null && right != null) {
            if (left.val < right.val) {
                sorted.next = left;
                left = left.next;
            } else {
                sorted.next = right;
                right = right.next;
            }
            sorted = sorted.next;
        }

        sorted.next = null != left? left : right;

        return temp.next;
    }

}