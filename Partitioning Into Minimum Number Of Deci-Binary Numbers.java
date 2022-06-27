class Solution {
    public int minPartitions(String n) {
        int a = 0;
        for(int i=0;i<n.length();i++) 
            a = Math.max(a,n.charAt(i)-'0');
        return a;
    }
}
