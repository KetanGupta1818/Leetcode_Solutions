class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        Queue<ListNode> Q = new LinkedList<>();
        Stack<ListNode> S = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            Q.add(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow;
        slow = slow.next;
        temp.next = null;
        if(fast==null) S.push(temp);
        else Q.add(temp);
        while(slow!=null){
            S.push(slow);
            slow = slow.next;
        }
        Q.remove();
        ListNode cur = head;
        cur.next = S.pop();
        cur = cur.next;
        while(!Q.isEmpty()){
            cur.next = Q.remove();
            cur = cur.next;
            if(!S.isEmpty()){
                cur.next = S.pop();
                cur = cur.next;
            }
        }
    }
}
