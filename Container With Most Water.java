class Solution {
    public int maxArea(int[] height) {
        int start=0,end=height.length-1,area=0;
        while(start<end){
            area = Math.max(area,Math.min(height[start],height[end])*(end-start));
            if(height[start]<height[end]) start++; else end--;
        }
        return area;
    }
}
