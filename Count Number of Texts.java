class Solution {
    public int countTexts(String pressedKeys) {
        int mod = 1_000_000_007;
        Set<Integer> setOfThrees = new HashSet<>(List.of(2, 3, 4, 5, 6, 8));
        long[] three = new long[Math.max(pressedKeys.length(),5)];
        long[] four = new long[Math.max(pressedKeys.length(),5)];
        three[0] = 1L;
        three[1] = 2L;
        three[2] = 4L;
        four[0] = 1L;
        four[1] = 2L;
        four[2] = 4L;
        four[3] = 8L;
        for(int i=3;i<three.length;i++){
            three[i] = (three[i-1]+three[i-2]+three[i-3])%mod;
        }
        for(int i=4;i<four.length;i++){
            four[i] = (four[i-1]+four[i-2]+four[i-3]+four[i-4])%mod;
        }
        long answer = 1L;
        int index = 0;
        while(index<pressedKeys.length()){
            int forward_index = index+1;
            while(forward_index<pressedKeys.length() && pressedKeys.charAt(forward_index)==pressedKeys.charAt(index))
                forward_index++;
           // System.out.println(forward_index);
            long cur_val = setOfThrees.contains(pressedKeys.charAt(index)-'0')?three[forward_index-index-1]:four[forward_index-index-1];
            answer = (answer*cur_val)%mod;
            index = forward_index;
        }
        //System.out.println(three[pressedKeys.length()-1]);
        return (int)answer;
    }
}
