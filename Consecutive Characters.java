class Solution {
    public int maxPower(String s) {
        int maxi = 1;
        int curMax = 1;
        for(int i=1;i<s.length();i++){
            int prev = i-1;
            if(s.charAt(prev)==s.charAt(i)){
                curMax++;
                if(curMax>maxi) maxi = curMax;
            }
            else{
                curMax = 1;
            }
        }
        return maxi;
    }
}
