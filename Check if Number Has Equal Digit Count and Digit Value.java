class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        int[] map = new int[n];
        for(int i=0;i<n;i++) {
            if(num.charAt(i) - '0' >= n ) return false;
            map[num.charAt(i)-'0']++;
        }
        for(int i=0;i<n;i++) if(map[i] != num.charAt(i)-'0') return false;
        return true;
    }
}
