class Solution {
    public int evalRPN(String[] tokens) {
        Stack stk = new Stack();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].length() == 1 && (tokens[i].charAt(0)=='+'||tokens[i].charAt(0)=='-'||tokens[i].charAt(0)=='*'||tokens[i].charAt(0)=='/')){
                char op = tokens[i].charAt(0);
                int first = (int)stk.pop();
                int second = (int)stk.pop();
                switch(op){
                    case '+': stk.push(second+first);break;
                    case '-': stk.push(second-first);break;
                    case '*': stk.push(second*first);break;
                    case '/': stk.push(second/first);break;
                }
            }
            else{            //These are numbers
                int val = Integer.parseInt(tokens[i]);
                stk.push(val);
            }
        }
        return (int)stk.pop();
    }
}
