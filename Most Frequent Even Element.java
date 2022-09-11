class Solution {
    public int mostFrequentEven(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int n: nums) map.put(n,map.getOrDefault(n,0)+1);
        int maxRep = 0;
        int number = -1;
        for(int n: map.keySet()){
            if(n%2==0 && map.get(n)>maxRep){
                maxRep = map.get(n);
                number = n;
            }
        }
        return number;
    }
}
