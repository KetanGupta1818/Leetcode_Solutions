class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        int n = words.length;
        List<Map<Integer,Integer>> listOfMaps = new ArrayList<>();
        for(int i=0;i<n;i++) listOfMaps.add(new HashMap<>());
        for(int j=0;j<n;j++){
            String word = words[j];
            for(int i=0;i<word.length();i++){
                int c = word.charAt(i) - 'a';
                listOfMaps.get(j).put(c,listOfMaps.get(j).getOrDefault(c,0)+1);
            }
        }
        for(int i=0;i<n-1;i++) {
            if(listOfMaps.get(i).equals(listOfMaps.get(i+1))) continue;
            ans.add(words[i+1]);
        }
        return ans;
    }
}
