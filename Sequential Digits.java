class Solution {
    SortedSet<Integer> set;
    public List<Integer> sequentialDigits(int low, int high) {
        set = new TreeSet<>();
        for(int i=1;i<=9;i++) helper(i);
        return new ArrayList<>(set.subSet(low,high+1));
    }
    public void helper(int start){
        if(start%10==9) {set.add(start);return;}
        set.add(start);
        helper(start*10 + (start%10+1));
    }
}
