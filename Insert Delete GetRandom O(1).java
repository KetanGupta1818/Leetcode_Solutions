class RandomizedSet {
    List<Integer> list;
    public RandomizedSet() {
        list = new LinkedList<>();
    }
    
    public boolean insert(int val) {
        if(list.indexOf(val)!=-1) return false;
        else list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(list.indexOf(val)==-1) return false;
        else list.remove(list.indexOf(val));
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
//Method 2
class RandomizedSet {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        list = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        else{
            list.add(val);
            map.put(val,list.size()-1);
        }
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        if(index<list.size()-1){
            int last_value = list.get(list.size()-1);
            list.set(map.get(val),last_value);
            map.put(last_value,map.get(val));
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
