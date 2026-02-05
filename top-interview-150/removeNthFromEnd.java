class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        for(int i = 0;i<n;i++)
            temp = temp.next;
        if(temp == null)
            return head.next;
        ListNode delete = head,prev = null;
        while(temp!=null){
            prev = delete;
            delete = delete.next;
            temp = temp.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
