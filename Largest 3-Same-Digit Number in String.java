class Solution {
    public String largestGoodInteger(String num) {
        int max = -1;
        for(int i=0;i<num.length()-3;i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i+1)==num.charAt(i+2))
                max = Math.max(max,num.charAt(i)-'0');
        }
        return max==-1?"": max +Integer.toString(max)+ max;
    }
}
