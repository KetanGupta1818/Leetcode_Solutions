class Solution {
    public long numberOfWays(String s) {
        long ways=0,zeros=0,ones=0,oneZero=0,zeroOne=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zeros++;
                oneZero+=ones;
                ways+=zeroOne;
            }
            else{
                ones++;
                zeroOne+=zeros;
                ways+=oneZero;
            }
        }
        return ways;
    }
}
