class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int hashChecker = 2;
        for(int i=0;i<s.length();i++){
            if(hashChecker<s.length() && s.charAt(hashChecker)=='#'){
                sb.append(getDoubleDigit(s.charAt(i++),s.charAt(i++)));
                hashChecker+=2;
            }
            else sb.append(getSingleDigit(s.charAt(i)));
            hashChecker++;
        }
        return sb.toString();
    }
    public char getSingleDigit(char c){
        return (char)(96+(c-'0'));
    }
    public char getDoubleDigit(char tens, char ones){
        return (char)(96+((tens-'0')*10+(ones-'0')));
    }
}
