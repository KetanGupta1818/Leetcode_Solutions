class Solution {
    public int arrangeCoins(int n) {
        double maxNumber = 1;
        int numberOfRows = 1;
        while(true){
            maxNumber = maxNumber + 1 + numberOfRows;
            if(n<maxNumber) break;
            numberOfRows++;
        }
        return numberOfRows;
    }
}
