//Brute Fore Method: O(n2) Time complexity
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int arr[] = new int[nums.length];
        int count;
        for(int i=0;i<nums.length;i++){
            count = 0;
            for(int j=0;j<nums.length;j++){
                if(j==i) continue;
                if(nums[i]>nums[j]) count++;
            }
            arr[i] = count;
        }
        return arr;
    }
}
