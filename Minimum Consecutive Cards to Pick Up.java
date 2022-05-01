class Solution {
    public int minimumCardPickup(int[] cards) {
        int size = Arrays.stream(cards).max().getAsInt() + 1;
        int minSize = Integer.MAX_VALUE;
        int[] map = new int[size];
        Arrays.fill(map,-1);
        for(int index=0;index<cards.length;index++){
            if(map[cards[index]]!=-1) {
                minSize = Math.min(minSize,index-map[cards[index]]+1);
            }
            map[cards[index]] = index;
        }
        return minSize==Integer.MAX_VALUE?-1:minSize;
    }
}
