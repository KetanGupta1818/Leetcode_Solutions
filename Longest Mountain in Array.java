//Time Complexity: 3*O(N) Space Complexity: 2*O(N) 
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] ls = new int[n];
        int[] rs = new int[n];
        for(int i=1;i<n;i++) if(arr[i]>arr[i-1]) ls[i]=ls[i-1]+1;
        for(int i=n-2;i>=0;i--) if(arr[i]>arr[i+1]) rs[i]=rs[i+1]+1;
        if(n<3 || rs[n-1]==n-1 || ls[n-1]==n-1) return 0;
        int max = 0;
        for(int i=1;i<n-1;i++){
            if(ls[i]!=0 && rs[i]!=0) max=Math.max(max,rs[i]+ls[i]+1);
        } 
        return max;
    }
}
//Two pointer solution. Let the base pointer be at the start of mountain. Traverse the array as if we are climbing the mountain and stop when we find a 
possible peak. After finding the possible peak we need to traverse the array as if we are returning from the peak. when this is done calculate the maximum 
value. :->

class Solution {
    public int longestMountain(int[] arr) {
        int base=0,n=arr.length,max=0;
        while(base<n){
            int end=base;
            if(end<n-1 && arr[end]<arr[end+1]){
                while(end<n-1 && arr[end]<arr[end+1]) end++;
                if(end<n-1 && arr[end]>arr[end+1]) {
                    while(end<n-1 && arr[end]>arr[end+1]) end++;
                    max=Math.max(max,end-base+1);
                }
            }
         
            base = Math.max(end, base + 1);
        }return max;
    }
}
