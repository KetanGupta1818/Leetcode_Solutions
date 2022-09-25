class Solution {
    public String longestNiceSubstring(String s) {
        int max = 0,n=s.length();
        String answer="";
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++) {
                if(isNice(s.substring(i,j+1))){
                    if(max<j-i+1){
                        max = j-i+1;
                        answer = s.substring(i,j+1);
                    }
                }
            }
        }
        return answer;
    }
    private boolean isNice(String s){
        int[] lower = new int[26];
        int[] upper = new int[26];
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i);
            if(c>=97) lower[c-'a']++;
            else upper[c-'A']++;
        }
        for(int i=0;i<26;i++) if((upper[i]>0 && lower[i]==0) || (lower[i]>0 && upper[i]==0)) return false;
        return true;
    }
}
