class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int index=0;
        while(index<command.length()){
            int cur = command.charAt(index);
            if(cur=='G') sb.append("G");
            else if(cur=='(' && command.charAt(index+1)==')'){
                sb.append("o");
                index++;
            }
            else{
                index+=3;
                sb.append("al");
            }
            index++;
        }
        return sb.toString();
    }
}
