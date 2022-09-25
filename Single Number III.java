 class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums) xor = xor  ^ num;
        int setBitPosition = rightMostSetBitIndex(xor);
        int setBitXor = 0;
        int unSetBitXor = 0;
        for(int num: nums) {
            if((num&(1<<(setBitPosition-1)))!=0) setBitXor = setBitXor^num;
            else unSetBitXor = unSetBitXor^num;
        }
        return new int[]{unSetBitXor,setBitXor};
    }
    private static int rightMostSetBitIndex(int n){
        return (int)((Math.log10(n & -n)) / Math.log10(2))+1;
    }
}
