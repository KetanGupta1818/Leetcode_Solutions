class Solution {
    public int minCostToMoveChips(int[] position) {
        int even_pos = (int)Arrays.stream(position)
            .filter(i->i%2==0)
            .count();
        return Math.min(even_pos,position.length-even_pos);
    }
}
