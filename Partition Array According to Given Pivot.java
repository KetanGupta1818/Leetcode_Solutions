class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessThanPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();
        int e = 0;
        for(int num: nums){
            if(num<pivot) lessThanPivot.add(num);
            else if(num>pivot) greaterThanPivot.add(num);
            else e++;
        }
        int[] ans = new int[nums.length];
        int index = 0;
        for(int i:lessThanPivot){
            ans[index++] = i;
        }
        for(int i=0;i<e;i++) ans[index++]=pivot;
        for(int i:greaterThanPivot) ans[index++]=i;
        return ans;
    }
}
