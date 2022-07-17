class Solution {
    public int maximumSum(int[] nums) {
        int max = -1;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int num: nums){
            int sum = getSumOfDigits(num);
            List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
            list.add(num);
            map.put(sum,list);
        }
        for(int sum: map.keySet()){
            if(map.get(sum).size() == 1) continue;
            List<Integer> list = map.get(sum);
            list.sort((a,b)->b-a);
            max = Math.max(max, list.get(0)+list.get(1));
        }
        return max;
    }
    private int getSumOfDigits(int num){
        int n = num;
        int sum = 0;
        while(n!=0){
            sum = sum + n%10;
            n = n/10;
        }
        return sum;
    }
}
