class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int textCoverage = 0;
        int spacesLeft = maxWidth;
        for(String word: words){
            if (spacesLeft < word.length()) {
                answer.add(justified(currentLine, maxWidth, textCoverage));
                currentLine = new ArrayList<>();
                spacesLeft = maxWidth;
                textCoverage = 0;
            }
            spacesLeft -= word.length()+1;
            textCoverage += word.length();
            currentLine.add(word);
        }
        String lastLine = justified(currentLine,textCoverage+currentLine.size()-1,textCoverage);
        lastLine = lastLine + " ".repeat(maxWidth-(textCoverage+currentLine.size()-1));
        answer.add(lastLine);
        return answer;
    }
    private String justified(List<String> words, int maxWidth, int textCoverage){
        if(words.size()==1) return oneWord(words,maxWidth);
        int spacesToBeInserted = maxWidth-textCoverage;
        int rem = spacesToBeInserted % (words.size()-1);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<words.size();i++){
            String word = words.get(i);
            res.append(word);
            if(i!=words.size()-1){
                res.append(" ".repeat(spacesToBeInserted/(words.size()-1)));
                if(rem>0) {
                    res.append(" ");
                    rem--;
                }
            }
        }
        return res.toString();
    }
    private String oneWord(List<String> words, int maxWidth){
        return words.get(0)+" ".repeat(maxWidth-words.get(0).length());
    }
}
