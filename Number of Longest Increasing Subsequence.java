class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] count = new int[n];
        int answerLis = 0;
        for(int i=n-1;i>=0;i--){
            int maxLis=1,c=1;
            for(int j=i+1;j<n;j++){
                if(nums[j]<=nums[i]) continue;
                int curLis = lis[j]+1;
                if(maxLis<curLis) {
                    maxLis = curLis;
                    c=count[j];
                }
                else if(maxLis==curLis) c+=count[j];
            }
            count[i]=c;
            lis[i] = maxLis;
            answerLis = Math.max(maxLis,answerLis);
        }
        int answer = 0;
        for(int i=0;i<n;i++){
            if(lis[i]==answerLis) answer+=count[i];
        }
        return answer;
    }
}
