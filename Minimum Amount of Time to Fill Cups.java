class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int sum = amount[0]+amount[1];
        if(sum<=amount[2]) return amount[2];
        return (int)Math.ceil((sum-amount[2])/2f) + amount[2];
    }
}
