class Solution {
    public int[] findOriginalArray(int[] changed) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int z = 0;
        for(int c: changed) {
            if(c==0) z++;
            else map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Integer> answer = new ArrayList<>();
        if(z%2==1) return new int[]{};
        else for(int i=0;i<z/2;i++) answer.add(0);
        for(int num: map.keySet()){
            if(map.get(num)==0) continue;
            if(map.get(num)>map.getOrDefault(num*2,0)) return new int[]{};
            map.put(num*2,map.get(num*2)-map.get(num));
            for(int i=0;i<map.get(num);i++) answer.add(num);
        }
        int[] a = new int[answer.size()];
        for(int i=0;i<a.length;i++) a[i] = answer.get(i);
        return a;
    }
}
