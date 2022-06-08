class Solution {
    public int removePalindromeSub(String s) {
        return isPalindrome(s)?1:2;
    }
    private boolean isPalindrome(String s){
        int fp=0,bp=s.length()-1;
        while(fp<=bp){
            if(s.charAt(fp++)!=s.charAt(bp--)) return false;
        }
        return true;
    }
}
