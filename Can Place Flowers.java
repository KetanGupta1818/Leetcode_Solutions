/*Traverse the whole array once and coutn zeros who have i-1 and i+1 as zero and update those zeros to ones. If the total calculated zeros are more  
than and equal to n; return true else return false*/
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0)) {count++;flowerbed[i]=1;}
        }
        return count>=n;
    }
}
