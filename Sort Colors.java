class Solution {
    public void sortColors(int[] nums) {
        int[] A = new int[nums.length];
        int[] C = new int[3];
        for(int i=0;i<nums.length;i++) A[i]=nums[i];
        for(int i=0;i<3;i++) C[i]=0;
        for(int i=0;i<nums.length;i++) C[A[i]]++;
        for(int i=1;i<3;i++) C[i]=C[i]+C[i-1];
        for(int i=0;i<nums.length;i++){
            nums[C[A[i]]-1] = A[i];
            C[A[i]]--;
        }
        return;
    }
}
//Counting Sort 
