class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans=0;
        Arrays.sort(boxTypes,((b1,b2)->b2[1]-b1[1]));
        for(int i=0;i<boxTypes.length;i++){
            if(truckSize<=0) break;
            int[] b = boxTypes[i];
            if(b[0]<truckSize) ans += b[0]*b[1];
            else ans += truckSize*b[1];
            truckSize -= b[0];
        }
        return ans;
    }
}
