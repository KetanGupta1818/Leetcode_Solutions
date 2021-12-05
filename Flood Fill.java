class Solution {
    public static int key;
    public static HashSet<String> set;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        key = image[sr][sc];
        set = new HashSet<>();
        helper(image,sr,sc,newColor);
        return image;
    }
    public void helper(int[][] image,int i, int j, int newColor){
        image[i][j] = newColor;
        String ch = Integer.toString(i) + " " + Integer.toString(j);
        if(set.contains(ch)) return;
        else set.add(ch);
        if(i>0 && image[i-1][j]==key) helper(image,i-1,j,newColor);
        if(j>0 && image[i][j-1]==key) helper(image,i,j-1,newColor);
        if(i<image.length-1 && image[i+1][j]==key) helper(image,i+1,j,newColor);
        if(j<image[0].length-1 && image[i][j+1]==key) helper(image,i,j+1,newColor);
    }
}
//0 ms
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int key = image[sr][sc];
        if(key==newColor) return image;
        helper(image,sr,sc,key,newColor);
        return image;
    }
    public void helper(int[][] image,int i, int j,int key, int newColor){
        image[i][j] = newColor;
        if(i>0 && image[i-1][j]==key) helper(image,i-1,j,key,newColor);
        if(j>0 && image[i][j-1]==key) helper(image,i,j-1,key,newColor);
        if(i<image.length-1 && image[i+1][j]==key) helper(image,i+1,j,key,newColor);
        if(j<image[0].length-1 && image[i][j+1]==key) helper(image,i,j+1,key,newColor);
    }
}
