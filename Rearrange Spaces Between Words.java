class Solution {
    public String reorderSpaces(String text) {
        int len = text.length();
        int c = f(text);
        int spaces = len-c;
        String[] words = text.trim().replaceAll(" +"," ").split(" ");
        if(words.length==1) return words[0]+" ".repeat(len-words[0].length());
        StringBuilder res = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            res.append(word);
            if(i!=words.length-1) res.append(" ".repeat(spaces/(words.length-1)));
        }
        res.append(" ".repeat(len-res.length()));
        return res.toString();
    }
    private int f(String text){
        int c=0;
        for(int i=0;i<text.length();i++) if(text.charAt(i)!=' ') c++;
        return c;
    }
}
