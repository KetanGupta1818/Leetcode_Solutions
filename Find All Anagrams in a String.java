//If any time number of zeros in hash table is 26; we put that start index in the list.
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int start=0;
        if(s.length()<p.length()) return new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int[] sArray = s.chars().map(i->i-97).toArray(); //For String "abcz"; sArray=[0,1,2,25] 
        int[] hashTable = new int[26];
        for(int i=0;i<p.length();i++) hashTable[p.charAt(i)-97]++;
        int end = p.length()-1;
        for(int i=0;i<p.length();i++) --hashTable[sArray[i]]; //Inital window
        while(end<s.length()-1){
            if(isZeros26(hashTable)) answer.add(start);
            ++hashTable[sArray[start++]];
            --hashTable[sArray[++end]];
        }
        if(isZeros26(hashTable)) answer.add(start);
        return answer;
    }
    public boolean isZeros26(int[] arr){
        int z = 0;
        for(int i: arr) if(i==0) z++;
        return z==26;
    }
}
