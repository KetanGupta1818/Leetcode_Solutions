class Solution {
    public int maximumXOR(int[] nums) {
        int res = 0;
        for(int i: nums) res|=i;
        return res;
    }
}
