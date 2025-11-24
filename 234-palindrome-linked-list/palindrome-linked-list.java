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
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return check(head);
    }

    public boolean check(ListNode head){
        if(head == null){
            return true;
        }
        boolean ans = check(head.next);
        if(!ans) return false;
        if(head.val != left.val){
            return false;
        }
        left = left.next;
        return ans;
    }
}