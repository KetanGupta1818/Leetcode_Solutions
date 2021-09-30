class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum_array = new int[n];
        sum_array[0] = nums[0];
        for(int i=1;i<n;i++) sum_array[i] = sum_array[i-1]+nums[i];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i==0){
                    if(k==sum_array[j]) count++;
                }
                else{
                    if(k==sum_array[j]-sum_array[i-1]) count++;
                }
            }
        }
        return count;
    }
}
