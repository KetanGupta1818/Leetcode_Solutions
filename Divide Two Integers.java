class Solution {
    public int divide(int D, int d) {
       long ans = 0L;
        long dividend = (long)D;
        long divisor = (long)d;
        boolean negative = (dividend<0 && divisor>0) || (dividend>0 && divisor<0);
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        System.out.println(Long.toString(dividend));
        while(dividend >= divisor){
            int reps = 1;
            while(dividend - (divisor << reps) >= 0) reps++;
            ans += (1<<(reps-1));
            dividend = dividend - (divisor << (reps-1));
        }
        return negative?(-1)*(int)ans:(int)ans;
    }
}
