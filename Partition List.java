class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode headLesser = lesser;
        ListNode headGreater = greater;
        while(head!=null){
            ListNode curNode = new ListNode(head.val);
            if(head.val>=x) {
                greater.next = curNode;
                greater = greater.next;
            }
            else{
                lesser.next = curNode;
                lesser = lesser.next;
            }
            head = head.next;
        }
        lesser.next = headGreater.next;
        return headLesser.next;
    }
}
