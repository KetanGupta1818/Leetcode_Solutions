//Created an array of linked list
class MyHashMap {

    LinkedList<Entry>[] map;
    public static int SIZE = 769;
    @SuppressWarnings("unchecked")
	public MyHashMap() {
    	map = new LinkedList[SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = key % SIZE;
        if(map[bucket] == null) {
        	Entry temp = new Entry(key,value);
        	LinkedList<Entry> newList = new LinkedList<>();
        	newList.add(temp);
        	map[bucket] = newList;
        	return;
        }
        for(Entry entry: map[bucket]) {
        	if(entry.key == key) {
        		entry.val = value;
        		return;
        	} 
        }
        Entry temp = new Entry(key,value);
        map[bucket].add(temp);
        return;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = key % SIZE;
        if(map[bucket]==null) return -1;
        LinkedList<Entry> entries = map[bucket];
        for(Entry entry: entries) {
        	if(entry.key == key) return entry.val;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = key%SIZE;
        if(map[bucket]==null) return;
        for(Entry entry: map[bucket]) {
        	if(entry.key == key) {
        	map[bucket].remove(entry);
        	return;
        	}
        }
    }
}
class Entry{
    int val;
    int key;
    public Entry(int key, int val){
        this.val = val;
        this.key = key;
    }
}
