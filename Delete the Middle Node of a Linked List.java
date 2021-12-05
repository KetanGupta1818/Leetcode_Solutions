class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = null;
        while(fast!=null && fast.next!=null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
    if(fast!=null && slow.next == null && fast.next==null) return null;
        prevSlow.next = slow.next;
        return head;
    }
}
