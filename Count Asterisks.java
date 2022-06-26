class Solution {
    public int countAsterisks(String s) {
        boolean isPaired = false;
        int counter = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isPaired==false && c=='*') counter++;
            else if(c == '|'){
                if(isPaired == false) isPaired = true;
                else isPaired = false;
            }
        }
        return counter;
    }
}
