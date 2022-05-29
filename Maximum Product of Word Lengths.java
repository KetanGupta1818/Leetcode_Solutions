class Solution {
   public int maxProduct(String[] words) {
        int n = words.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            String word = words[i];
            int val = 0;
            for(int j=0;j<word.length();j++){
                val = val | (1 << (word.charAt(j)-'a'));
            }
            arr[i] = val;
        }
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((arr[i]&arr[j])==0 && max<words[i].length()*words[j].length()) max=words[i].length()*words[j].length();
            }
        }
        return max;
    }
}
