class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuffer str = new StringBuffer();
        while(head!=null) {
            str.append(head.val);
            head = head.next;
        }
        str = str.reverse();
        int number = 0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='0') continue;
            number = number + (int)(Math.pow(2,i));
        }
        return number;
    }
}
