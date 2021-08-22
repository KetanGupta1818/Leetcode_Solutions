int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    * returnSize = 2;
    int *arr = (int*)malloc(2*sizeof(int));
    for(int i=0;i<numsSize;i++){
        for(int j=i+1;j<numsSize;j++){
            if(nums[j] +   nums[i]  == target){
                arr[0] = i;
                arr[1] = j;
                return arr;
            }
        }
    }
    
    return arr;
}
