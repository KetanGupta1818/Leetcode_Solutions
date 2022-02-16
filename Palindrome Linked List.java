class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseList(slow.next);
        ListNode a = head;
        slow = slow.next;
        while(slow!=null){
            if(a.val!=slow.val) return false;
            a = a.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next  == null) return head;
        ListNode second = head.next;
        head.next = null;
        ListNode reversed = reverseList(second);
        second.next = head;
        return reversed;
    }
}
