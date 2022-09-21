class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int evenSum = 0, oddSum = 0;
        for(int num: nums) {
            if(num%2 == 0) evenSum += num;
            else oddSum += num;
        }
        int[] answer = new int[queries.length];
        for(int q=0;q<queries.length;q++){
            int[] query = queries[q];
            int value = query[0];
            int index = query[1];
            if(nums[index]%2==0){
                if(value%2==0) evenSum += value;
                else{
                    evenSum -= nums[index];
                    oddSum += nums[index]+value;
                }
            }
            else{
                if(value%2 == 0) oddSum += value;
                else{
                    oddSum -= nums[index];
                    evenSum += nums[index]+value;
                }
            }
            nums[index] += value;
            answer[q] = evenSum;
        }
        return answer;
    }
}
