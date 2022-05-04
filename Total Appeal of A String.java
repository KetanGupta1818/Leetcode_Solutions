class Solution {
    public long appealSum(String s) {
        int[] lastOccurrence = new int[26];
        long sum = 0L,answer = 0L;
        Arrays.fill(lastOccurrence,-1);
        for(int i=0;i<s.length();i++){
            sum+=(i+1)-(lastOccurrence[s.charAt(i)-'a']+1);
            lastOccurrence[s.charAt(i)-'a'] = i;
            answer += sum;
        }
        return answer;
    }
}
