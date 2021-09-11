import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Queue<Integer> Q = new LinkedList<>();
        int[] C = new int[1000];
        for(int i=0;i<1000;i++) C[i]=0;
        for(int i=0;i<nums1.length;i++) C[nums1[i]]++;
        for(int i=0;i<nums2.length;i++){
            if(C[nums2[i]]>0){
                Q.add(nums2[i]);
                C[nums2[i]]--;
            }
        }
        int n = Q.size();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = Q.remove();
        return arr;
    }
}
