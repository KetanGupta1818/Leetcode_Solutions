class Solution {
    public int[] sortByBits(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<15;i++)
            list.add(new ArrayList<>());
        for(int e: arr)
            list.get(numberOfOneBits(e)).add(e);
        int[] answer=new int[arr.length];
        int index=0;
        for(int i=0;i<15;i++){
            Collections.sort(list.get(i));
            for(int e: list.get(i)) answer[index++]=e;
        }
        return answer;
        
    }
    public int numberOfOneBits(int n){
        int count=0;
        while(n>0){
            count+= (n&1);
            n>>>=1;
        }
        return count;
    }
}
