class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>  res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) twoSum(nums,i,res);
        }
        return res;
    }
    public void twoSum(int[] nums, int i, List<List<Integer>> res){
        int low = i+1;
        int high = nums.length-1;
        while(low<high){
            int sum = nums[low] + nums[high] + nums[i];
            if(sum == 0){
                List<Integer> a = new ArrayList<>();
                a.add(nums[i]);
                a.add(nums[low]);
                a.add(nums[high]);
                low++;
                high--;
                while(low<high && nums[low-1] == nums[low]) low++;
                res.add(a);
            }
            else if(sum>0) high--;
            else low++;
        }
    }
}
