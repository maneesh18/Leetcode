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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-200);
        ListNode more = new ListNode(-200);
        ListNode temp = head, ltemp = less, mtemp = more;
        while(temp != null){
            if(temp.val < x){
                ltemp.next = temp;
                ltemp = ltemp.next;
                temp = temp.next;
                ltemp.next = null;
            }else{
                mtemp.next = temp;
                mtemp = mtemp.next;
                temp = temp.next;
                mtemp.next = null;
            }
        }
        ltemp.next = more.next;
        return less.next;
    }
}
