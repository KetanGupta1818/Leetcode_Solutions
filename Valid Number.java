class Solution {
    public boolean isNumber(String s) {
        if(s.charAt(0)=='-' || s.charAt(0)=='+') s=s.substring(1);
        if(s.length()==0) return false;
        if(s.length()==1 && !Character.isDigit(s.charAt(0))) return false;
        if(s.length() == 1) return true;
        if(s.charAt(0)=='-' || s.charAt(0)=='+' || s.charAt(s.length()-1)=='+' || s.charAt(s.length()-1)=='-') return false;
        Map<Character,Integer> map = new HashMap<>();
        if(s.length()==1 && !Character.isDigit(s.charAt(0))) return false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) c = Character.toLowerCase(c);
            if(c=='.' && map.containsKey('e')) return false;
            if(c=='+' || c=='-') {
                if(s.charAt(i-1)=='e' || s.charAt(i-1)=='E') continue;
                return false;
            }
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(char c: map.keySet()){
            if(Character.isDigit(c)) continue;
            if(c=='e' || c=='.'){
                if(map.get(c)==1) continue;
                else return false;
            }
            return false;
        }
        if(map.containsKey('.'))return isValidDecimal(s);
        return isValidInteger(s);
    }
    private boolean isValidInteger(String s){
        int indexOfE = -101;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'e' || s.charAt(i)=='E') indexOfE = i;
        }
        return indexOfE!=0 && indexOfE!=s.length()-1;
    }
    private boolean isValidDecimal(String s){
        int indexOfPoint = -1;
        for(int i=0;i<s.length();i++) if(s.charAt(i)=='.') indexOfPoint=i;
        String leftSide = s.substring(0,indexOfPoint);
        String rightSide = s.substring(indexOfPoint+1);
        return isValidInteger(leftSide) && isValidInteger((leftSide.isEmpty()?"":"0")+rightSide);
    }
}
