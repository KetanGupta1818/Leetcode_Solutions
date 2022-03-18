class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] seen = new boolean[26];
        int[] lastIndex = new int[26];
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) lastIndex[s.charAt(i)-'a'] = i;
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(seen[cur-'a']) continue;
            while(!stack.isEmpty() && (stack.peek()-'a'>cur-'a') && i<lastIndex[stack.peek()-'a']) seen[stack.pop()-'a'] = false;
            stack.push(cur);
            seen[cur-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
