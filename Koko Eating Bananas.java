class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for(int pile: piles){
            right = Math.max(pile,right);
        }
        while(left<right){
            int mid = (left+right)/2;
            int hoursSpend = 0;
            for(int pile: piles) hoursSpend+=Math.ceil((double) pile/mid);
            //System.out.println("Hello: " + hoursSpend);
            if(hoursSpend<=h) right = mid;
            else left = mid+1;
        }
        return right;
    }
}
