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
