class Solution {
    public boolean hasAllCodes(String s, int k) {
        int num = 0;
        int found = 1;
        if(s.length()<k) return false;
        for(int i=0;i<k;i++) if(s.charAt(i) == '1') num += 1 << k-1-i;
        int mask = (1 << k-1) -1;
        boolean[] visited = new boolean[1<<k];
        visited[num] = true;
        for(int i=0;i<s.length()-k;i++){
            num = num & mask;
            num = num << 1;
            num = num + (s.charAt(i+k)-'0');
            if(!visited[num]){
                found++;
                visited[num] = true;
            }
            if(found == 1<<k) return true;
        }
        return false;
    }
}
