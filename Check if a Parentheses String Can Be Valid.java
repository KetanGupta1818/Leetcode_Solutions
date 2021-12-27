class Solution {
    public boolean canBeValid(String s, String locked) {
        
        if(s.length()%2==1) return false;
        int numberOfLeftBrackets = 0;    // ')'
        int numberOfRightBrackets = 0;   // '('
        //int numberOfWildCharacters = 0;   //unlocked Character represented with 0 in locked String
        //In left to right traversal look for unbalanced ')'.
        for(int i=0;i<s.length();i++){
            if(numberOfLeftBrackets>numberOfRightBrackets) return false;
            if(locked.charAt(i)=='0' || s.charAt(i)=='(') numberOfRightBrackets++;
            else numberOfLeftBrackets++;
        }
        numberOfLeftBrackets = 0;   
        numberOfRightBrackets = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(numberOfRightBrackets>numberOfLeftBrackets) return false;
            if(locked.charAt(i)=='0' || s.charAt(i)==')') numberOfLeftBrackets++;
            else numberOfRightBrackets++;
        }
        return true;
    } 
}
