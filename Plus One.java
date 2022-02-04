class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int pointer = n-1;
        while(pointer>=0){
            digits[pointer] = (digits[pointer]+1)%10;
            if(digits[pointer--]!=0)  return digits;
        }
        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;
    }
}
