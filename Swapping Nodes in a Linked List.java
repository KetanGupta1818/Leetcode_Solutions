class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        while(--k!=0) first = first.next;
        ListNode end = first;
        ListNode second = head;
        while(end.next!=null){
            second = second.next;
            end = end.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}
