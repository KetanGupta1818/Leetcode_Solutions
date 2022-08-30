class Solution {
    public int findContentChildren(int[] g, int[] s) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i: g) map.put(i,map.getOrDefault(i,0)+1);
        int counter = 0;
        for(int i: s){
            Integer child = map.floorKey(i);
            if(child!=null){
                counter++;
                map.put(child,map.get(child)-1);
                if(map.get(child)==0) map.remove(child);
            }
        }
        return counter;
    }
}
