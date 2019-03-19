/**
 * 3 ms	39.7 MB
 * 6 ms	40.2 MB
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part, 
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group: 
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list 
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
    
    // my solution
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        LinkedList<ListNode> link = new LinkedList<>();
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            link.push(head);
            if (link.size() == k) {
                while (!link.isEmpty()) {
                    list.add(link.pop());
                }
            }
            head = head.next;
        }
        while (!link.isEmpty()) {
            list.add(link.pollLast());
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.get(i).next = null;
                break;
            }
            list.get(i).next = list.get(i+1);
        }
        return list.get(0);
    }
}
