class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer currentString = new StringBuffer();
        int index=0;
        while(index<strs[0].length()){
            char c = strs[0].charAt(index);
            for(String s: strs){
                if(index>=s.length() || c!=s.charAt(index)) return currentString.toString();
            }
            index++;
            currentString.append(c);
        }
        return currentString.toString();
    }
}
