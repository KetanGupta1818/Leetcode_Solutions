public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        if(head == null) return null;
        if(head.next==null) return null;
        if(head.next.next == head) return head;
        while(head!=null){
            if(hs.contains(head)) return head;
            else hs.add(head);
            head = head.next;
        }
        return null;
    }
}
