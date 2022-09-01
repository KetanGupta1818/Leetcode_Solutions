class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLengthOfLinkedList(l1);
        int length2 = getLengthOfLinkedList(l2);
        ListNode head = new ListNode(0);
        if(length1>length2){
            ListNode cur = head;
            for(int i=0;i<length1-length2-1;i++){
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            cur.next = l2;
            Pair pair = addTwoLinkedLists(l1,head);
            if(pair.remainder == 0) return pair.linkedList;
            ListNode one = new ListNode(1);
            one.next = pair.linkedList;
            return one;
        }
        else if(length2>length1){
//            System.out.println("length2>length1");
            ListNode cur = head;
            for(int i=0;i<length2-length1-1;i++){
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            cur.next = l1;
            Pair pair = addTwoLinkedLists(l2,head);
            if(pair.remainder == 0) return pair.linkedList;
            ListNode one = new ListNode(1);
            one.next = pair.linkedList;
            return one;
        }
        Pair pair = addTwoLinkedLists(l1,l2);
        if(pair.remainder == 0) return pair.linkedList;
        ListNode one = new ListNode(1);
        one.next = pair.linkedList;
        return one;
    }
    private int getLengthOfLinkedList(ListNode cur){
        if(cur == null) return 0;
        return getLengthOfLinkedList(cur.next)+1;
    }
    private Pair addTwoLinkedLists(ListNode head1, ListNode head2){
        if(head1.next == null){
            if(head2.next!=null) System.out.println("Head2.next should also be null: error");
            return new Pair(new ListNode((head1.val+head2.val)%10),(head1.val+head2.val)/10);
        }
        Pair pair = addTwoLinkedLists(head1.next,head2.next);
        ListNode cur = new ListNode((pair.remainder+head1.val+head2.val)%10);
        cur.next = pair.linkedList;
        return new Pair(cur,(pair.remainder+head1.val+head2.val)/10);
    }
}
class Pair{
    ListNode linkedList;
    int remainder;

    public Pair(ListNode linkedList, int remainder) {
        this.linkedList = linkedList;
        this.remainder = remainder;
    }
}
