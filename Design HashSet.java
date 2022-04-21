class MyHashSet {
    int[] set;
    public MyHashSet() {
        set = new int[1_000_001];
    }
    
    public void add(int key) {
        set[key] = 1;
    }
    
    public void remove(int key) {
        set[key] = 0;
    }
    
    public boolean contains(int key) {
        return set[key] == 1;
    }
}
