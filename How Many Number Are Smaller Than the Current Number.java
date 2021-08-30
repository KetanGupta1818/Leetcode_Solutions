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
//Counting Sort: O(n) Time Complexity
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int max = 0,i;
        for(i=0;i<nums.length;i++){
            if(nums[i]>max) max = nums[i];
        }
        int B[] = new int[nums.length];
        int C[] = new int[max+1];
        for(i=0;i<=max;i++) C[i] = 0;
        for(i=0;i<nums.length;i++) C[nums[i]] = C[nums[i]] + 1;
        for(i=1;i<=max;i++) C[i] = C[i] + C[i-1];
        for(i=0;i<nums.length;i++){
            if(nums[i]==0) B[i]=0;
            else B[i] = C[nums[i]-1];
        }
        return B;
    }
}
