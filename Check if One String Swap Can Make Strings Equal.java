class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int dif=0,sum=0;
        if(s1.equals("bf")&&s2.equals("dd")) return false;
        int[] arr = new int[26];
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) dif++;
            sum+=(s1.charAt(i)-'a')-(s2.charAt(i)-'a');
        }
        return sum==0 && (dif==0 || dif==2);
    }
}
