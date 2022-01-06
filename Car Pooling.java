```
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] np = new int[1001];
        for(int[] trip: trips){
            np[trip[1]]+=trip[0];
            np[trip[2]]-=trip[0];
        }
        if(np[0]>capacity) return false;
        for(int i=1;i<np.length;i++){
            np[i]=np[i]+np[i-1];
            if(np[i]>capacity) return false;
        }
        return true;
    }
}
```
