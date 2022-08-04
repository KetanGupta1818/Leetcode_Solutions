class Solution {
    public int mirrorReflection(int p, int q) {
        int lcm = (p*q)/getGCD(p,q);
        int n = lcm/q;
        int m = lcm/p;
        if(n%2==0) return 2;
        else if(m%2==1) return 1;
        return 0;
    }
    public int getGCD(int x, int y){
        int a = Math.max(x,y);
        int b = Math.min(x,y);
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
