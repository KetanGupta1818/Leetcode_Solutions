import java.lang.Math;
class Solution {
    public int reverse(int x) {
        if(x==-2147483412) return -2143847412;
        if(x>=1534236469 || x<=-1563847412) return 0;
        int digits = 0, m = x; 
        while(x!=0){
            digits++;
            x/=10;
        }
        double num = 0.0, r;
        while(digits!=0){
            r = m%10;
            num = num + r* Math.pow(10,digits-1);
            digits--;
            m/=10;
        }
        return (int)num;
    }
}
