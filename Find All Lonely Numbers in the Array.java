class Solution {
    public List<Integer> findLonely(int[] nums) {
        int n = nums.length;
        int[] arr = new int[1000001];
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            arr[i]++;
            if(i>max) max = i;
        }
        List<Integer> list = new ArrayList<>();
        if(n==1) {list.add(nums[0]);return list;}
        if(arr[0]==1 && arr[1]==0) list.add(0);
        for(int i=1;i<max;i++){
            if(arr[i]==1 && arr[i-1]==0 && arr[i+1]==0) list.add(i);
        }
        if(arr[max]==1 && arr[max-1]==0) list.add(max);
        return list;
    }
}
