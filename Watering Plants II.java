class Solution {
            public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int refill = 0;
        if(n==1) return 0;
        int i = 0;
        int j = n-1;
        int cca = capacityA;
        int ccb = capacityB;
        while(i<j){
            if(cca<plants[i]){
                refill++;
                cca = capacityA;
                cca = cca - plants[i];
            }
            else cca = cca - plants[i];
            i++;
            if(ccb<plants[j]){
                refill++;
                ccb = capacityB;
                ccb = ccb - plants[j];
            }
            else ccb = ccb - plants[j];
            j--;
        }
        if(i==j){
            int mw = Math.max(cca,ccb);
            if(mw<plants[i]) refill++;
        }
        return refill;
    }
}
