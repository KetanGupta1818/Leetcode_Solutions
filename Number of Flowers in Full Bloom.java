class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int[] st = new int[flowers.length];
        int[] end = new int[flowers.length];
        int index = 0;
        for(int[] flower: flowers){
            st[index] = flower[0];
            end[index] = flower[1];
            index++;
        }
        Arrays.sort(st);
        Arrays.sort(end);
        int[] answer = new int[persons.length];
        index=0;
        for(int p: persons){
            answer[index++] = bs(st,p) - bs(end,p-1);
        }
        return answer;
    }
    public int bs(int[] arr, int target){
        int lo=0,hi=arr.length-1,index=-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]>target) hi=mid-1;
            else{
                index = Math.max(index,mid);
                lo=mid+1;
            }
        }
        return index+1;
    }
}
