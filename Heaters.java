class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int answer = Integer.MIN_VALUE;
        for(int house: houses){
            int location = searchInsert(heaters,house);
            if(location==0)
                answer=Math.max(answer,heaters[0]-house);
            else if(location==heaters.length)
                answer=Math.max(answer,house-heaters[heaters.length-1]);
            else
                answer=Math.max(answer,Math.min(house-heaters[location-1],heaters[location]-house));
        }
        return answer;
    }
    public int searchInsert(int[] nums, int target) {
        int lo=0,hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) hi=mid-1;
            else lo=mid+1;
        }
        return lo;
    }
}
