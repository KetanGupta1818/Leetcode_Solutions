class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0,curGas=0,remainGas=0;
        for(int i=0;i<gas.length;i++){
            curGas+=gas[i]-cost[i];
            if(curGas<0){
                remainGas+=curGas;
                start=i+1;
                curGas=0;
            }
        }
        return remainGas+curGas>=0?start:-1;
    }
}
