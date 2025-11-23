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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        add(dummy, l1, l2, 0);
        return dummy.next;
    }

    public void add(ListNode prev, ListNode l1, ListNode l2, int carry){
        if(l1== null && l2 == null && carry == 0){
            return;
        }
        if(l1 == null && l2 == null){
            ListNode newNode = new ListNode(carry);
            prev.next = newNode;
            return;
        }
        if(l1 == null){
            int sum = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode newNode = new ListNode(sum);
            prev.next = newNode;
            add(prev.next, null, l2.next, carry);
            return;
        }
        if(l2 == null){
            int sum = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode newNode = new ListNode(sum);
            prev.next = newNode;
            add(prev.next, null, l1.next, carry);
            return;
        }

        int sum = (l1.val + l2.val + carry) % 10;
        carry = (l1.val + l2.val + carry) / 10;
        ListNode newNode = new ListNode(sum);
        prev.next = newNode;
        add(prev.next, l1.next, l2.next, carry);
    }
}