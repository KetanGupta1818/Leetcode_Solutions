class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num: nums) list.add(num+k);
        list.sort(Collections.reverseOrder());
        int answer = list.get(0) - list.get(n-1);
        for(int i=0;i<n-1;i++){
            list.set(i,list.get(i)-2*k);
            int max = Math.max(list.get(0),list.get(i+1));
            int min = Math.min(list.get(i),list.get(n-1));
            answer = Math.min(answer,Math.abs(max-min));
        }
        return answer;
    } 
}
