class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        for(int i=0;i<s.length();i++){
            int currentCharacter = s.charAt(i);
            if(Character.isDigit(currentCharacter)){
                 currentNumber = (currentNumber*10)+ (currentCharacter-'0');
            }
            if(!Character.isDigit(currentCharacter)&&!Character.isWhitespace(currentCharacter)||i==s.length()-1){
                if(operation=='-') stack.push(-currentNumber);
                else if(operation=='+') stack.push(currentNumber);
                else if(operation=='*') {
                    int number1 = stack.pop();
                    stack.push(number1*currentNumber);
                }
                else if(operation=='/'){
                    int number1 = stack.pop();
                    stack.push(number1/currentNumber);
                }
                operation = (char)currentCharacter;
                currentNumber=0;
                
            }
        }
        int result=0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
