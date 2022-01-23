class Solution {
    public int countElements(int[] nums) {
        int n = nums.length;
        if(n==1 || n==2) return 0;
        int max = Integer.MIN_VALUE;
        int numberOfMax = 0;
        int min = Integer.MAX_VALUE;
        int numberOfMin = 0;
        for(int i: nums){
            if(i>max){
                max = i;
                numberOfMax = 1;
            }
            else if(i==max) numberOfMax++;
            if(i<min){
                min = i;
                numberOfMin = 1;
            }
            else if(i==min) numberOfMin++;
        }
        if(max==min) return 0;
        return n-numberOfMax-numberOfMin;
    }
}
