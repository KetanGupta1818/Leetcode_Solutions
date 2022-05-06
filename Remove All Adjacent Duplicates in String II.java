class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            int char_val=(int)s.charAt(i),rep=1;
            if(!stack.isEmpty() && char_val==stack.peek()[0]){
                if(stack.peek()[1] == k-1){
                    for(int j=0;j<k-1;j++) stack.pop();
                    continue;
                }
                rep = stack.peek()[1]+1;
            }
            stack.push(new int[]{char_val,rep});
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append((char)stack.pop()[0]);
        }
        return sb.reverse().toString();
    }
}
