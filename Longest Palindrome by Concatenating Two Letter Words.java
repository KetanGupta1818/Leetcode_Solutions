class Solution {
    public int longestPalindrome(String[] words) {
        int[][] counter = new int[26][26];
        int answer = 0;
        for(String w: words){
            int a = w.charAt(0) - 'a';
            int b = w.charAt(1) - 'a';
            if(counter[b][a]>0){
                answer = answer + 4;
                counter[b][a]--;
            }
            else counter[a][b]++;
        }
        for(int i=0;i<26;i++){
            if(counter[i][i]>0){
                answer = answer + 2;
                break;
            }
        }
        return answer;
    }
}
