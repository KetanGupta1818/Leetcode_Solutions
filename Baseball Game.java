class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String str: ops){
            if(str.equals("C")) stack.pop();
            else if(str.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                int c = a+b;
                stack.push(b);
                stack.push(a);
                stack.push(c);
            }
            else if(str.equals("D")){
                stack.push(stack.peek()*2);
            }
            else stack.push(Integer.parseInt(str));
        }
        int answer = 0;
        System.out.println(stack);
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        return answer;
    }
}
