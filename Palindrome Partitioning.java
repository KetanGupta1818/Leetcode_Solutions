class Solution {
        public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0,result,s,new ArrayList<String>());
        return result;
    }
    void dfs(int start, List<List<String>> result, String s, List<String> currentString){
        if(start >= s.length()){
            result.add(new ArrayList<String>(currentString));
            return;
        }
        for(int end = start; end<s.length();end++){
            if(isPalindrome(s,start,end)){
                currentString.add(s.substring(start,end+1));
                dfs(end+1,result,s,currentString);
                currentString.remove(currentString.size()-1);
            }
        }
    }
    boolean isPalindrome(String s, int low, int high){
        while(low<high){
            if(s.charAt(low++)!=s.charAt(high--)) return false;
        }
        return true;
    }
}
