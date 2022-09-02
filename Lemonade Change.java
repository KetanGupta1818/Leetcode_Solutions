class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] coins = new int[2];
        for(int bill: bills){
            if(bill == 5) coins[0]++;
            else if(bill == 10){
                coins[0]--;
                coins[1]++;
                if(coins[0]<0) return false;
            }
            else{
                if(coins[1]>0 && coins[0]>0){
                    coins[1]--;
                    coins[0]--;
                }
                else if(coins[0]>2) coins[0] -= 3;
                else return false;
            }
        }
        return true;
    }
}
