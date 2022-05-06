class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo=0,hi=letters.length-1;
        while(lo<=hi){
            int m = lo + (hi - lo)/2;
            int dif = letters[m] - target;
            if(dif>0) hi=m-1;
            else lo=m+1;
        }
        return lo==letters.length?letters[0]:letters[lo];
    }
}
