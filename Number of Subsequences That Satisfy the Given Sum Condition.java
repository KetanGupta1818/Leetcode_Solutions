class Solution {
    private static int MOD = 1_000_000_007;
    private static long[] powers;
    static {
        powers = new long[100002];
        powers[0] = 1L;
        for(int i=1;i<=100001;i++){
            powers[i] = (powers[i-1]*2)%MOD;
        }
    }
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int left=0,right=n-1;
        long answer = 0L;
        while(left <= right){
            while(left<=right && nums[left]+nums[right] > target  ) right--;
            if(left>right) break;
            answer = (answer+powers[right-left])%MOD;
            left++;
        }
        return (int)answer;
    }
}
