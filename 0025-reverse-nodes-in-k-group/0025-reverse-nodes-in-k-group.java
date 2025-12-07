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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        while (true) {
            ListNode kth = getKthNode(current, k);
            if (kth == null) break; // Not enough nodes left

            ListNode nextGroupStart = kth.next;

            // Reverse group
            ListNode prev = nextGroupStart;
            ListNode temp = current;
            while (temp != nextGroupStart) {
                ListNode nextTemp = temp.next;
                temp.next = prev;
                prev = temp;
                temp = nextTemp;
            }

            // Connect previous group to the newly reversed group
            prevGroupEnd.next = kth;

            // Move pointers to prepare for next group
            prevGroupEnd = current;
            current = nextGroupStart;
        }

        return dummy.next;
    }

    // Helper to get the kth node from current
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 1) {
            start = start.next;
            k--;
        }
        return start;
    }
}
