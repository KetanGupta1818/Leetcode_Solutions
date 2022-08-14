class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1;i<=n+1;i++) queue.offer(i);
        StringBuilder answer = new StringBuilder();
        int index = 0;
        while(index<n){
            if(pattern.charAt(index) == 'I'){
                if(answer.length() == index+1) {index++;continue;}
                answer.append(queue.remove());
            }
            else{
                StringBuilder cur = new StringBuilder();
                cur.append(queue.remove());
                while(index<n-1 && pattern.charAt(index+1)=='D'){
                    index++;
                    cur.append(queue.remove());
                }
                if(!queue.isEmpty()){
                    cur.append(queue.remove());
                }
                answer.append(cur.reverse());
            }
            index++;
        }
        if(answer.length()==n) answer.append(queue.remove());
        return answer.toString();
    }
}
