class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Queue<Character> pq = new PriorityQueue<>((a,b)->b-a);
        for(char c: s.toCharArray()) pq.offer(c);
        StringBuffer res = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        char previousChar = pq.peek();
        while(!pq.isEmpty()){
            char cur = pq.poll();
            if(cur==previousChar){
                if(count<repeatLimit) res.append(cur);
                else stack.push(cur);
                count++;
            }
            else{
                if(stack.isEmpty()){
                    count = 1;
                    res.append(cur);
                    previousChar = cur;
                }
                else{
                    res.append(cur);
                    count = 0;
                    while(!stack.isEmpty() && count<repeatLimit){
                        res.append(stack.pop());count++;
                    }
                }
            }
            
        }return res.toString();
    }
}
