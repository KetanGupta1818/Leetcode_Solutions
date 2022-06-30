//Incrementing n-1 values is equal to decrementing 1 value;
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i: nums) min=Math.min(min,i);
        int ans=0;
        for(int i: nums) ans+=i-min;
        return ans;
    }
}
