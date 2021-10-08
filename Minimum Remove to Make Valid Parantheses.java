class Solution {
    public static String minRemoveToMakeValid(String s) {
        StringBuffer str = new StringBuffer(s);
        Stack<Character> stkLeft = new Stack<>();
        Stack<Character> stkRight = new Stack<>();
        //Forward Traversal
        for(int i=0;i<str.length();i++) {
        	char c = str.charAt(i);
        	if(c!='(' && c!=')') continue;
        	if(c=='(') {
        		stkRight.push(')');
        	}
        	else {
        		if(stkRight.isEmpty()) {
        			str.deleteCharAt(i);
        			i--;
        		}
        		else {
        			stkRight.pop();
        		}
        	}
        }
        for(int i=str.length()-1;i>=0;i--) {
        	char c = str.charAt(i);
        	if(c!='(' && c!=')') continue;
        	if(c==')') {
        		stkLeft.push('(');
        	}
        	else {
        		if(stkLeft.isEmpty()) {
        			str.deleteCharAt(i);
        			
        		}
        		else {
        			stkLeft.pop();
        		}
        	}
        }
        return str.toString();
    }
}
