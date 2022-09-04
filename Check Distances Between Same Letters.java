class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] first = new int[26];
        int[] answer = new int[26];
        boolean[] visited = new boolean[26];
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i)-'a';
            if(!visited[c]) first[c] = i;
            else answer[c] = i-first[c]-1;
            visited[c] = true;
        }
        for(int i=0;i<26;i++){
            if(visited[i] && distance[i]!=answer[i]) return false;
        }
        return true;
    }
}
