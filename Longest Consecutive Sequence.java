class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        MapUnion un = new MapUnion();
        for(int num: set) if(set.contains(num+1)) un.union(num,num+1);
        Map<Integer,Integer> roots = new HashMap<>();
        for(int i: set) roots.put(un.find(i),roots.getOrDefault(un.find(i),0)+1);
        int max = 0;
        for(int r: roots.keySet()) max = Math.max(max,roots.get(r));
        return max;
    }
}
class MapUnion{
    private Map<Integer,Integer> map;
    public MapUnion(){
        map = new HashMap<>();
    }
    public int find(int v){
        map.putIfAbsent(v,v);
        if(v != map.get(v)) map.put(v,find(map.get(v)));
        return map.get(v);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) map.put(rootX,rootY);
    }
}
