class Solution {
    public int findGCD(int[] nums) {
        int a = Integer.MIN_VALUE, b = Integer.MAX_VALUE;
        for(int i: nums){
            a = Math.max(a,i);
            b = Math.min(b,i);
        }
        return gcd(a,b);
    }
    private int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
