class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Queue<Integer>> map = new TreeMap<>((a,b)->a-b);
        for(int num: nums){
            int mappedNumber=0;
            String stringNumber = Integer.toString(num);
            for(int i=0;i<stringNumber.length();i++){
                int d = mapping[Integer.parseInt(stringNumber.substring(i,i+1))];
                mappedNumber = mappedNumber*10+d;
            }
            if(num==0) mappedNumber=mapping[0];
            Queue<Integer> list = map.getOrDefault(mappedNumber,new ArrayDeque<>());
            list.add(num);
            map.put(mappedNumber,list);
        }
        int[] answer = new int[nums.length];
        int index=0;
        for(int k: map.keySet()){
            Queue<Integer> list = map.get(k);
            for(Integer number: list){
                answer[index++] = number;
            }
        }
        return answer;
    }
}
