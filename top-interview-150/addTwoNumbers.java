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
        ListNode thead,head = new ListNode(-1);
        thead = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            int temp = l1.val + l2.val + carry;
            head.next = new ListNode(temp%10);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
            carry = temp/10;
        }
        while(l1 != null){
            int temp = l1.val + carry;
            head.next = new ListNode(temp%10);
            head = head.next;
            l1 = l1.next;
            carry = temp/10;
        }
        while(l2 != null){
            int temp = l2.val + carry;
            head.next = new ListNode(temp%10);
            head = head.next;
            l2 = l2.next;
            carry = temp/10;
        }
        if(carry == 1)
            head.next = new ListNode(1);
        return thead.next;
    }
}
