/*
index--> 6 5 4 3 2 1 0           
    16 = 0 0 1 0 0 0 0
    17 = 0 0 1 0 0 0 1
    71 = 1 0 0 0 1 1 1
    62 = 0 1 1 1 1 1 0
    12 = 0 0 0 1 1 0 0
    24 = 0 0 1 1 0 0 0
    14 = 0 0 0 1 1 1 0 
    
    If we and AND all numbers we will get 0.
    62 & 12 gives 0001100 (There are ones present at index 3 and 2)

    Approach: To maximize number of elements whose AND will result a number greater than zero find maximum number of ones that lie in a particular index.
    
    In our case 62,12,24,14 have 1 at index 3. Thus doing a AND operation on them will result to a number greater than zero(0001000).
    
    Solution: To solve this problem use a int[] array to store frequency of ones at particular index and return the maximum frequency as the answer.
    
    Time Complexity: O(nlogn) logn: Calculation of frequency of 1's and n: scanning all inputs.
    Space Complexity: O(1)
*/
class Solution {
    public int largestCombination(int[] candidates) {
        int[] arr = new int[24];  //1_000_000_0's binary representation has length of 24
        for(int candidate: candidates){
            int index = 0;
            while(candidate>0){
                if((candidate&1)==1) arr[index]++;
                candidate = candidate >>> 1;
                index++;
            }
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}

