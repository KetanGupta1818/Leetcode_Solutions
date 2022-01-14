class Solution {
   public int wordCount(String[] startWords, String[] targetWords) {
        int n = startWords.length;
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            char[] arr = startWords[i].toCharArray();
            Arrays.sort(arr);
            set.add(new String(arr));
        }
        int count = 0;
        for(int i=0;i< targetWords.length;i++){
            char[] arr = targetWords[i].toCharArray();
            Arrays.sort(arr);
            String target = new String(arr);
            if(set.contains(target.substring(1))||set.contains(target.substring(0,target.length()-1))){
                count++;
                continue;
            }
            for(int c=1;c<target.length()-1;c++){
                if(set.contains(target.substring(0,c)+target.substring(c+1))){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
