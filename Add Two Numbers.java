class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lsum = new ListNode(0,null);
        ListNode cur_sum = lsum;
        ListNode cur_l1 = l1;
        ListNode cur_l2 = l2;
        int carry = 0;
        int values = cur_l1.val + cur_l2.val + carry;
        carry = values/10;
        values = values%10;
        lsum.val = values;
        cur_l1 = cur_l1.next;
        cur_l2 = cur_l2.next;
        while(cur_l1!=null && cur_l2!=null){
            int value = cur_l1.val + cur_l2.val + carry;
            carry = value/10;
            value = value%10;
            ListNode temp = new ListNode(value, null);
            cur_sum.next = temp;
            cur_sum = cur_sum.next;
            cur_l1 = cur_l1.next;
            cur_l2 = cur_l2.next;            
        }
        while(cur_l1!=null){
            int value = cur_l1.val +  carry;
            carry = value/10;
            value = value%10;
            ListNode temp = new ListNode(value, null);
            cur_sum.next = temp;
            cur_sum = cur_sum.next;
            cur_l1 = cur_l1.next;               
        }
        while(cur_l2!=null){
            int value = cur_l2.val +  carry;
            carry = value/10;
            value = value%10;
            ListNode temp = new ListNode(value, null);
            cur_sum.next = temp;
            cur_sum = cur_sum.next;
            cur_l2 = cur_l2.next;               
        }
        if(carry!=0){
            ListNode temp = new ListNode(carry, null);
            
            cur_sum.next = temp;
        }
        return lsum;
    }
}
