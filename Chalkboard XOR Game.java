class Solution {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for(int i: nums) xor = xor^i;
        return xor == 0 || nums.length%2==0;
    }
}
