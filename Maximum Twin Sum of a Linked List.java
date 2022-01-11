class Solution {
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //Find middle of the list using two pointers
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            list.add(slow.val); //Keep track of first half values while traversing
            slow = slow.next;
            fast = fast.next.next;
        }
        int max = -1;
        int backPointer = 1;
        while(slow!=null){ //Compare second half values..
            max = Math.max(max,list.get(list.size()-backPointer++)+slow.val);
            slow = slow.next;
        }
        return max;
    }
}
