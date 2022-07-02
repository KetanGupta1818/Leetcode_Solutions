class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int dif_h = horizontalCuts[0], dif_v = verticalCuts[0];
        for(int i=0;i<horizontalCuts.length-1;i++) 
            dif_h = Math.max(horizontalCuts[i+1]-horizontalCuts[i],dif_h);
        for(int i=0;i<verticalCuts.length-1;i++) 
            dif_v = Math.max(verticalCuts[i+1]-verticalCuts[i],dif_v);
        dif_h = Math.max(h-horizontalCuts[horizontalCuts.length-1],dif_h);
        dif_v = Math.max(w-verticalCuts[verticalCuts.length-1],dif_v);
        long ans = (long)dif_v * (long)dif_h;
        return (int)(ans%1_000_000_007);
    }
}
