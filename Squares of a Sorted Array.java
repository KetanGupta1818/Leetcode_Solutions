class Solution {
       public static int[] sortedSquares(int[] nums) {
        int index = findFirstPositiveIndex(nums);
        if(index == 0){
            return Arrays.stream(nums)
                    .map(e->e*e)
                    .toArray();
        }
        int[] answer = new int[nums.length];
        int answerPointer = 0;
        int positivePointer = index;
        int negativePointer = index-1;
        while(positivePointer<nums.length && negativePointer>=0){
            if(nums[positivePointer]>=Math.abs(nums[negativePointer])){
                answer[answerPointer] = nums[negativePointer]*nums[negativePointer];
                answerPointer++;
                negativePointer--;
            }
            else{
                answer[answerPointer] = nums[positivePointer]*nums[positivePointer];
                answerPointer++;
                positivePointer++;
            }
        }
        while(negativePointer>=0){
            answer[answerPointer] = nums[negativePointer]*nums[negativePointer];
            answerPointer++;
            negativePointer--;
        }
        while(positivePointer<nums.length){
            answer[answerPointer] = nums[positivePointer]*nums[positivePointer];
            answerPointer++;
            positivePointer++;
        }
        return answer;
    }
    public static int findFirstPositiveIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        if(nums[right]<0) return right;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<0){
                left = mid + 1;
            }
            else{
                if(mid == 0 || nums[mid-1]<0) return mid;
                else right = mid-1;
            }
        }
        return -1;
    }
}
