class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode last = head;
        int counter = 0;
        while(last!=null && counter!=(k-1)){
            counter++;
            last = last.next;
        }
        if(last==null) return head; //End of linked list. Return the head of the remaning list.
        ListNode ln = last.next;
        last.next = null;//It will be used in reversing single elements.
        ListNode reversed = reverseKGroup(ln,k);
        ListNode hold = head;//Used in joing the head of non reverse list to the reversed list.
        ListNode srev = reverseList(head); //Single reversal
        hold.next = reversed;
        return srev;
    }
    //This function reverses single elements.
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next  == null) return head;
        ListNode second = head.next;
        head.next = null;
        ListNode reversed = reverseList(second);
        second.next = head;
        return reversed;
    }
}
