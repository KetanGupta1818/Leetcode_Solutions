class Solution {
    public int minBitFlips(int start, int goal) {
        String s = Integer.toBinaryString(start);
        String t = Integer.toBinaryString(goal);
        int zeros=0;
        int sLen = s.length();
        int tLen = t.length();
        if(sLen>tLen){
            while(tLen+zeros!=sLen){
                t = "0"+t;
                zeros++;
            }
        }
        else{
            while(sLen+zeros!=tLen){
                s = "0"+s;
                zeros++;
            }
        }
        if(s.length()!=t.length()) System.out.println("Error");
        int flips = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i)) flips++;
        }
        return flips;
    }
}
