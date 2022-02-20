class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode();
        head = head.next;
        int sum = 0;
        while(head.val!=0){
            sum+=head.val;
            head = head.next;
        }
        head = head.next;
        newHead.val = sum;
        ListNode currentNode = newHead;
        while(head!= null && head.next!=null){
            int s = 0;
            while(head.val!=0){
                s+=head.val;
                head = head.next;
            }
            currentNode.next = new ListNode(s);
            currentNode = currentNode.next;
            head = head.next;
        }
        return newHead;
    }
}
