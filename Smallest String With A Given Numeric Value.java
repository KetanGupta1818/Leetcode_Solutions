class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            int currentCharacterValue = Math.max(k-26*(i),1);
            sb.append((char)(currentCharacterValue+96));
            k = k - currentCharacterValue;
        }
        return sb.toString();
    }
}
