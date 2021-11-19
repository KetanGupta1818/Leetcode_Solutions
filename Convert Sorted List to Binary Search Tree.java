class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode temp = new TreeNode();
        if(head == null) return null;
        if(head.next == null) {
            temp.val = head.val;
            return temp;
        }
        ListNode middle = middleOf(head);
        temp.val = middle.val;
        ListNode p,q;
        p = head;
        while(p.next!=middle) p = p.next;
        p.next = null;
        q = middle.next;
        middle.next = null;
        temp.left = sortedListToBST(head);
        temp.right = sortedListToBST(q);
        return temp;
    }
    public ListNode middleOf(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
