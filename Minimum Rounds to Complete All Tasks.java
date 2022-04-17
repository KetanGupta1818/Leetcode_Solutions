class Solution {
    public int minimumRounds(int[] tasks) {
        int rounds = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: tasks) map.put(i,map.getOrDefault(i,0)+1);
        for(int key: map.keySet()){
            int n = map.get(key);
            if(n==1) return -1;
            if(n%3==0) rounds += n/3;
            else if(n%3==1) rounds += (n-4)/3 + 2;
            else rounds += (n-2)/3 + 1;
        }
        return rounds;
    }
}
