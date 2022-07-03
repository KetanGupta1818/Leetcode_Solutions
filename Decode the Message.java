class Solution {
    public String decodeMessage(String key, String message) {
        List<Character> list = new ArrayList<>();
        for(int i=0;i<key.length();i++) {
            if(key.charAt(i)!=' ' && !list.contains(key.charAt(i))) list.add(key.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<message.length();i++){
            if(message.charAt(i)!=' ') {
                char c = (char)(list.indexOf(message.charAt(i))+97);
                ans.append(c);
            }
            else ans.append(' ');
        }
        return ans.toString();
    }
}
