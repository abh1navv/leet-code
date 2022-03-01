public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

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

        if (left != null)
          sorted.next = left;

        if (right != null)
          sorted.next = right;

        return temp.next;
    }

}