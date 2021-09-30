class Solution {
    public static String addStrings(String num1, String num2) {
        String answer = new String();
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int carry = 0;
        while(len1>=0 && len2>=0) {
        	int val = carry + (num1.charAt(len1)-'0') + (num2.charAt(len2) - '0');
        	carry = val/10;
        	val = val % 10;
        	answer = Integer.toString(val) + answer;
        	len1--;
        	len2--;
        }
        if(len1<0 && len2<0 && carry!=0) {
        	answer = Integer.toString(carry) + answer;
            carry = 0;
        }
        while(len1>=0) {
        	int val = carry + (num1.charAt(len1)-'0');
        	carry = val/10;
        	val = val % 10;
        	answer = Integer.toString(val) + answer;
        	len1--;        	
        }
        while(len2>=0) {
        	int val = carry + (num2.charAt(len2)-'0');
        	carry = val/10;
        	val = val % 10;
        	answer = Integer.toString(val) + answer;
        	len2--;        	
        }
        if(carry!=0) answer = Integer.toString(carry) + answer;
        return answer;
    }
}
