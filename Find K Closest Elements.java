class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int i = bs(arr,x);
        int j = i+1;
        while(k!=0 && i>=0 && j<arr.length){
            if(x-arr[i] <= arr[j]-x) list.add(arr[i--]);
            else list.add(arr[j++]);
            k--;
        }
        while(k!=0 && i>=0) {list.add(arr[i--]);k--;}
        while(k!=0 && j<arr.length){list.add(arr[j++]);k--;}
        list.sort(null);
        return list;
    }
    private int bs(int[] arr, int target){
        int lo=0,hi=arr.length-1;
        while(lo <= hi){
            int m = (lo+hi)/2;
            if(arr[m] == target) return m;
            else if(arr[m] > target) hi = m-1;
            else lo = m+1;
        }
        return hi;
    }
}
