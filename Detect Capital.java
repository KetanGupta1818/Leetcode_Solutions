class Solution {
    public boolean detectCapitalUse(String word) {
        if(Character.isLowerCase(word.charAt(0))) return firstCharacterSmall(word);
        return firstCharacterCapital(word);
    }
    public boolean firstCharacterSmall(String word){
        return word.chars().allMatch(c->c>=97);
    }
    public boolean firstCharacterCapital(String word){
        return word.chars().allMatch(c->c<=90) || firstCharacterSmall(word.substring(1));
    }
}
