class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] map = new int[101];
        for(int i: nums) map[i]++;
        int[] ans = new int[2];
        for(int i=0;i<101;i++){
            ans[0] += map[i]/2;
            ans[1] += map[i]%2;
        }
        return ans;
    }
}
