class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> distinctNumbers = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            if(!distinctNumbers.add(num)) continue;
            int bits = numberOfSetBits(num);
            list.add(bits);
        }
        long answer = 0L;
        list.sort(null);
        int i=0,j=list.size()-1;
        while(i<=j){
            while(i<=j && list.get(i)+list.get(j)<k) i++;
            if(list.get(j)*2>=k) answer++;
            if(i>=j) break;
            answer += (long)(j-i)*2;
            j--;
        }
        return answer;
    }
    private int numberOfSetBits(int num){
        int bits = 0;
        while(num!=0){
            if((num&1)==1) bits++;
            num = num>>1;
        }
        return bits;
    }
}
