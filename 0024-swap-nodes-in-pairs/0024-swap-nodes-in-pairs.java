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
    public ListNode swapPairs(ListNode head) {
        // Dummy node to simplify pointer management
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        // Traverse while two nodes exist
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to next pair
            current = first;
        }

        return dummy.next;
    }
}
