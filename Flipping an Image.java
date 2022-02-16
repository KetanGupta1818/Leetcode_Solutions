class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] ans = new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++){
            for(int j=image[0].length-1;j>=0;j--){
                if(image[i][j]==0) ans[i][image[0].length-1-j]=1;
            }
        }
        return ans;
    }
}
