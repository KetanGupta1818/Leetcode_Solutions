class Solution {
    public boolean divideArray(int[] nums) {
        int[] arr = new int[501];
        for(int num: nums) arr[num]++;
        return Arrays.stream(arr).noneMatch(e->e%2==1);
    }
}
