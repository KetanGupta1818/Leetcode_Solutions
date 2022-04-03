class Solution {
     public int convertTime(String current, String correct) {
        int currentHours = Integer.parseInt(current.substring(0,2));
        int currentMinutes = Integer.parseInt(current.substring(3));
        int correctMinutes = Integer.parseInt(correct.substring(3));
        int correctHours = Integer.parseInt(correct.substring(0,2));
        int totalMinutes = (correctHours-currentHours)*60 + (correctMinutes-currentMinutes);
        int moves = 0;
        while(totalMinutes!=0){
            if(totalMinutes>=60) totalMinutes-=60;
            else if(totalMinutes>=15) totalMinutes-=15;
            else if(totalMinutes>=5) totalMinutes-=5;
            else totalMinutes-=1;
            moves++;
        }
        return moves;
    }
}
