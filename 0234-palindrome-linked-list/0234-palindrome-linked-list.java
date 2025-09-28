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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> palindr = new ArrayList<>();
        ListNode curr=head;
        while(curr != null){
            palindr.add(curr.val);
            curr=curr.next;
        }
        int i=0 , j=palindr.size()-1;
        while(i<=j){
            if(!palindr.get(i).equals(palindr.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
}