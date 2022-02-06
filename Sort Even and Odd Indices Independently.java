class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int evenLength;
        if(n%2==1) evenLength = n/2+1;
        else evenLength = n/2;
        int oddLength = n/2;
        int[] evenArr = new int[evenLength];
        Integer[] oddArr = new Integer[oddLength];
        int index = 0;
        for(int i=0;i<nums.length;i+=2){
            evenArr[index] = nums[i];
            index++;
        }
        index = 0;
        for(int i=1;i<nums.length;i+=2){
            oddArr[index] = nums[i];
            index++;
        }
        Arrays.sort(evenArr);
        Arrays.sort(oddArr,Collections.reverseOrder());
        int evenIndex = 0;
        int oddIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i] = evenArr[evenIndex++];
            }
            else nums[i] = oddArr[oddIndex++];

        }
        return nums;
    }
}
