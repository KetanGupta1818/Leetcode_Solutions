class Solution {
    public String countAndSay(int n) {
        return f(n,"1");
    }
    private String f(int rep,String s){
        if(rep==1) return s;
        int left=0,right=0;
        String res = "";
        while(right<s.length()){
            while(right<s.length() && s.charAt(right)==s.charAt(left)) right++;
            int size = right-left;
            res += Integer.toString(size) + s.charAt(left);
            left=right;
        }
        return f(rep-1,res);
    }
}
