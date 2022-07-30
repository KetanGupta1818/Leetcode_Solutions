class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n1 = words1.length;
        int n2 = words2.length;
        int[][] map1 = new int[n1][26];
        for(int i=0;i<n1;i++){
            String word = words1[i];
            for(int j=0;j<word.length();j++){
                map1[i][word.charAt(j)-'a']++;
            }
        }
        int[] minFreq = new int[26];
        for(int i=0;i<n2;i++){
            String word = words2[i];
            int[] cur = new int[26];
            for(int j=0;j<word.length();j++){
                cur[word.charAt(j)-'a']++;
            }
            for(int j=0;j<26;j++){
                minFreq[j] = Math.max(cur[j],minFreq[j]);
            }
        }
        List<String> answer = new ArrayList<>();
        m: for(int i=0;i<n1;i++){
            for(int j=0;j<26;j++){
                if(map1[i][j]<minFreq[j]) continue m;
            }
            answer.add(words1[i]);
        }
        return answer;
    }
}
