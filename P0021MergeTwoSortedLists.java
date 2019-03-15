/**
 * 5 ms	43.3 MB
 * 6 ms	44.4 MB
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    
    
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = l2;
                break;
            }
            if (l2 == null) {
                curr.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                curr.next = new ListNode(l1.val);
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                curr = curr.next;
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
