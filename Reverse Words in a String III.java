class Solution {
    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        return Arrays.stream(strings, 0, strings.length)
                .map(Solution::reverseWord)
                .collect(Collectors.joining(" "));
    }
    public static StringBuilder reverseWord(String word){
        StringBuilder newString = new StringBuilder();
        for(int i=word.length()-1;i>=0;i--) newString.append(word.charAt(i));
        return newString;
    }
}
