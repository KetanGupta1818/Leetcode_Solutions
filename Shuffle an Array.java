class Solution {

    int[] originalArray;
    int[] shuffledArray;
    Random random = new Random();
    public Solution(int[] nums) {
        this.originalArray = new int[nums.length];
        this.shuffledArray = new int[nums.length];
        System.arraycopy(nums, 0, originalArray, 0, nums.length);
        System.arraycopy(nums, 0, shuffledArray, 0, nums.length);
    }

    public int[] reset() {
        return this.originalArray;
    }

    public int[] shuffle() {
        for(int i=0;i<shuffledArray.length-1;i++){
            swap(i,getRandomInRange(i,shuffledArray.length));
        }
        return shuffledArray;
    }
    private void swap(int i, int j){
        int temp = shuffledArray[i];
        shuffledArray[i] = shuffledArray[j];
        shuffledArray[j] = temp;
    }
    private int getRandomInRange(int min, int max){
        return random.nextInt(max-min)+min;
    }
}
