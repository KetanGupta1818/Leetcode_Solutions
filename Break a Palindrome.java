class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n==1) return new String();
        StringBuffer str = new StringBuffer(palindrome);
        int i=0;
        for(i=0;i<n;i++){
            char c = str.charAt(i);
            if(c!='a'){
                str.replace(i,i+1,"a");
                if(!isPalindrome(str.toString(),n)) return str.toString();
                str.replace(i,i+1,Character.toString(c));
            }
        }
        str.replace(i-1,i,"b");
        return str.toString();
    }
    public boolean isPalindrome(String s, int n){
        int second;
        if(n%2==1) second=n/2+1;
        else second = n/2;
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(second+i)) return false;
        }
        return true;
    }
}
