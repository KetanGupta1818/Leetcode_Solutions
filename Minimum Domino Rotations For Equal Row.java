class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int num1 = tops[0];
        int num2 = bottoms[0];
        int answer1=-1;
        int answer2=-1;
        if(checkIfValidNumber(tops,bottoms,num1)){
            int topCounter=0;
            int bottomCounter=0;
            for(int i=0;i<tops.length;i++){
                if(tops[i]==bottoms[i]) continue;
                else if(tops[i]==num1) topCounter++;
                else bottomCounter++;
            }
            answer1=Math.min(topCounter,bottomCounter);
        }
        if(checkIfValidNumber(tops,bottoms,num2)){
            int topCounter=0;
            int bottomCounter=0;
            for(int i=0;i<tops.length;i++){
                if(tops[i]==bottoms[i]) continue;
                else if(tops[i]==num2) topCounter++;
                else bottomCounter++;
            }
            answer2=Math.min(topCounter,bottomCounter);
        }
        if(answer1==-1 && answer2==-1) return -1;
        if(answer2==-1) return answer1;
        if(answer1==-1) return answer2;
        return Math.min(answer1,answer2);
    }
    public boolean checkIfValidNumber(int[] tops, int[] bottoms, int num){
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=num && bottoms[i]!=num) return false;
        }
        return true;
    }
}
