//Thinking: Either add pattern[0] at the start ot add pattern[1] at end. 
//We will start by assuming that we added pattern[0] at the start. 
//If pattern[0]==pattern[1]. Then number of sequences are like,, n + n-1 + n-2 + .... 1
class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int firstCharacters=1; //Number of Pattern[0] counted.
        long answer1=0L; //Pattern[0] added at start
        long answer2=0L; //Pattern[1] added at end
        for(int i=0;i<text.length();i++){
            char cur = text.charAt(i);
            if(cur==pattern.charAt(0)) firstCharacters++;
            if(cur==pattern.charAt(1)){
                answer1+=firstCharacters; 
                answer2+=(firstCharacters-1); //As Pattern[0] is not added at start. Total number of firstCharacters is always 1 less than case1.
            }
        }
        if(pattern.charAt(0)==pattern.charAt(1)) return (long) (firstCharacters) *(firstCharacters-1)/2;
        return Math.max(answer1,answer2+(firstCharacters-1));
        //answer2+(firstCharacters-1) As we added pattern[1] at end it has (firstCharacters-1) to form sequences..
    }
}

//Hey I am a absoulte beginner. Any suggestion for improvement of this solution is highly appreciated.. 
