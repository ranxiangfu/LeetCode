/**
 * 5 ms	38.1 MB
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        nodes.add(node);
        while (node.next != null) {
            nodes.add(node.next);
            node = node.next;
        }
        if (n == nodes.size()) {
            if (n == 1) {
                return null;
            }
            return nodes.get(1);
        }
        ListNode pre = nodes.get(nodes.size() - n - 1);
        if (n == 1) {
            pre.next = null;
            return nodes.get(0);
        }
        pre.next = nodes.get(nodes.size() - n + 1);
        return nodes.get(0);
    }
}
