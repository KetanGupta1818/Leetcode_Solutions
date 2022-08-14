class Solution {
    public int edgeScore(int[] edges) {
        TreeMap<Long,Long> map = new TreeMap<>();
        for(int i=0;i<edges.length;i++) map.put((long)edges[i],map.getOrDefault((long)edges[i],0L)+i);
        long max = -1L;
        long index = -1L;
        for(long key: map.keySet()){
            if(map.get(key)>max){
                max = map.get(key);
                index = key;
            }
        }
        return (int)index;
    }
}
