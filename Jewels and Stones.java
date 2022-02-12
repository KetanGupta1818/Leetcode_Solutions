class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Integer> setOfJewels = jewels.chars().boxed().collect(Collectors.toSet());
        return (int)stones.chars().filter(setOfJewels::contains).count();
    }
}
