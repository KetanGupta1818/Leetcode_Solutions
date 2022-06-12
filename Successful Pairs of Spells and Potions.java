class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int[] answer = new int[spells.length];
            for(int i=0;i<answer.length;i++) answer[i] =  potions.length - bs(potions,(long)spells[i],success);
            return answer;
    }
    private int bs(int[] arr, long num, long success){
        int lo = 0, hi = arr.length-1;
        while(lo<=hi){
            int m = (lo+hi)/2;
            if(arr[m]*num>=success) hi=m-1;
            else lo=m+1;
        }
        return lo;
    }
}
