class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val==val) head = head.next;
        if(head == null || (head.next==null && head.val==val)) return null;
        ListNode cur = head;
        ListNode temp = head.next;
        while(temp!=null){
            if(temp.val==val){
                cur.next = temp.next;
                temp.next = null;
                temp = cur.next;
                continue;
            }
            temp = temp.next;
            cur = cur.next;
        }
        return head;
    }
}
