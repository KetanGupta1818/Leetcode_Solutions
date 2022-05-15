class Solution {
    public int divisorSubstrings(int num, int k) {
        int answer = 0;
        String str = Integer.toString(num);
        for(int i=0;i<=str.length()-k;i++){
            if(Integer.parseInt(str.substring(i,i+k)) == 0) continue;
            if(num%Integer.parseInt(str.substring(i,i+k)) == 0) answer++;
        }
        return answer;
    }
}
