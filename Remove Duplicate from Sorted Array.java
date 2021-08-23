class Solution {
    public int removeDuplicates(int[] nums) {
    int k = 1;
    int rep_count = 0;
    try{
        int cur_ele = nums[0];
    }
    catch(ArrayIndexOutOfBoundsException e){
        return 0;
    }
    int cur_ele = nums[0];
    int numsSize = nums.length;
    for(int i=1;i<numsSize;i++){
        if(nums[i]!=cur_ele){
            k++;
            cur_ele = nums[i];
            nums[i-rep_count] = cur_ele;
        }
        else{
            rep_count++;
            
        }
    }
    return k;
    }
}
