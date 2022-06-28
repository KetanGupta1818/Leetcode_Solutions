class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++) arr[s.charAt(i)-'a']++;
        Arrays.sort(arr);
        for(int i=0;i<13;i++){
            int temp = arr[i];
            arr[i] = arr[25-i];
            arr[25-i] = temp;
        }
        //System.out.println(Arrays.toString(arr));
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<26;i++){
            if(arr[i] == 0) break;
            set.add(arr[i]);
        }
      //  System.out.println(set);
        int res = 0;
        for(int i=0;i<25;i++){
            if(arr[i] == 0) return res;
            if(arr[i]!=arr[i+1]) continue;
            int cv = nextEmpty(arr[i],set);
            res += arr[i]-cv;
        }
        return res;
    }
    private int nextEmpty(int x,HashSet<Integer> set){
        while(set.contains(x)) x--;
        if(x != 0) set.add(x);
        return x;
    }
}
