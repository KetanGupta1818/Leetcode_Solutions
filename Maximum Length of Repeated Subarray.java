class Solution {
    public int findLength(int[] n1, int[] n2) {
        int n = Math.max(n1.length,n2.length);
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        if(n1.length>=n2.length){
            for(int i=0;i<n;i++){
                nums1[i] = n1[i];
                nums2[i] = n2[i%n2.length];
            }
        }
        if(n1.length<n2.length){
            for(int i=0;i<n;i++){
                nums2[i] = n2[i];
                nums1[i] = n1[i%n1.length];
            }
        }
        int answer=0;
        for(int shift=0;shift<n;shift++){
            int[] arr = new int[n+1];
            arr[n-shift] = 10000;
            for(int i=0;i<n;i++) {
                arr[(i>=n-shift)?i+1:i] = nums1[i] - nums2[(i+shift)%n];
            }
            answer = Math.max(answer,maximumNumberOfConsecutiveZero(arr));
        }
        return answer;
    }
    private int maximumNumberOfConsecutiveZero(int[] arr){
        int max=0,lp=0;
        for(int rp=0;rp<arr.length;rp++){
            if(arr[rp]!=0){
                max = Math.max(max,rp-lp);
                lp=rp+1;
            }
        }
        return Math.max(max,arr.length-lp);
    }
}
