//Using array to store frequncy of digits
class Solution {
    private int[] map = new int[10];
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null) return 0;
        map[root.val]++;
        int res = (root.left==null && root.right==null && isPalindrome(map))?1:0;
        res += pseudoPalindromicPaths(root.left)+pseudoPalindromicPaths(root.right);
        map[root.val]--;
        return res;
    }
    private boolean isPalindrome(int[] map){
        int odd = 0;
        for(int m: map) if(m%2==1) odd++;
        return odd<2;
    }
}



//Bit masking
class Solution {
    int mask=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null) return 0;
        mask ^= (1<<root.val);
        int res = (root.left==null && root.right==null && isPalindrome(mask))?1:0;
        res += pseudoPalindromicPaths(root.left)+pseudoPalindromicPaths(root.right);
        mask ^= (1<<root.val);
        return res;
    }
    private boolean isPalindrome(int n){
        int b=0;
        while(n>0){
            if((n&1)==1) b++;
            n>>=1;
        }
        return b<2;
    }
}
