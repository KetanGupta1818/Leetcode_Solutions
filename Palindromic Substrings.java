class Solution {
    public int countSubstrings(String s) {
        int n=s.length(),count=0;
        for(int p=0;p<n;p++){ //Odd length substrings
            int i=p,j=p;
            while(i>=0 && j<n && s.charAt(i--)==s.charAt(j++)) count++;
        }
        for(int p=0;p<n-1;p++){ //Even length substrings
            int i=p,j=p+1;
            while(i>=0 && j<n && s.charAt(i--)==s.charAt(j++)) count++;
        }
        return count;
    }
}
