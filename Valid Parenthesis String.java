class Solution {
    public boolean checkValidString(String s) {
        if(s.length()==0) return true;
       // if(s.length()==1) return false;
        int numberOfLeftBrackets = 0; //'('
        int numberOfRightBrackets = 0; //')'
        int numberOfWildCards = 0;
        for(int i=0;i<s.length();i++){
            if(numberOfRightBrackets>numberOfLeftBrackets+numberOfWildCards) return false;
            char currentCharacter = s.charAt(i);
            if(currentCharacter=='*') numberOfWildCards++;
            else if(currentCharacter==')') numberOfRightBrackets++;
            else numberOfLeftBrackets++;
        }
        if(numberOfRightBrackets>numberOfLeftBrackets+numberOfWildCards) return false;
        numberOfLeftBrackets=0;
        numberOfRightBrackets=0;
        numberOfWildCards=0;
        for(int i=s.length()-1;i>=0;i--){
            if(numberOfLeftBrackets>numberOfRightBrackets+numberOfWildCards) return false;
            char currentCharacter = s.charAt(i);
            if(currentCharacter=='*') numberOfWildCards++;
            else if(currentCharacter==')') numberOfRightBrackets++;
            else numberOfLeftBrackets++;
        }
            if(numberOfLeftBrackets>numberOfRightBrackets+numberOfWildCards) return false;
        return true;
    }
}
