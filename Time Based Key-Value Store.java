class TimeMap {
    Map<String, TreeSet<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeSet<Pair> treeSet = map.getOrDefault(key,new TreeSet<>(Comparator.comparingInt(p -> p.timestamp)));
        treeSet.add(new Pair(value,timestamp));
        map.put(key,treeSet);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        Pair p = map.get(key).floor(new Pair("",timestamp));
        if(p == null) return "";
        return p.value;
    }

}
class Pair{
    String value;
    int timestamp;
    
    public Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
