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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 0;
    ListNode nod = head;
    
    // Step 1: count total nodes
    while (nod != null) {
        nod = nod.next;
        count++;
    }
    
    // Step 2: if removing the first node
    if (n == count) {
        return head.next;
    }
    
    // Step 3: move to the node before the one to remove
    ListNode temp = head;
    for (int i = 1; i < count - n; i++) {
        temp = temp.next;
    }
    
    // Step 4: remove nth node
    temp.next = temp.next.next;
    
    return head;
    }

}