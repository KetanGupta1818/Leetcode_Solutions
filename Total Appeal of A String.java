class Solution {
    public long appealSum(String s) {
        int[] lastOccurrence = new int[26];
        long sum = 1L,answer = 1L;
        Arrays.fill(lastOccurrence,-1);
        lastOccurrence[s.charAt(0)-'a'] = 0;
        for(int i=1;i<s.length();i++){
            sum+=(i+1)-(lastOccurrence[s.charAt(i)-'a']+1);
            lastOccurrence[s.charAt(i)-'a'] = i;
            answer += sum;
        }
        return answer;
    }
}
