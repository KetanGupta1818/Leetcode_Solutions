class SnapshotArray {
    List<TreeSet<Pair>> map;
    int snapId;
    public SnapshotArray(int length) {
        this.map = new ArrayList<>();
        for(int i=0;i<length;i++) map.add(new TreeSet<>((p1,p2)->p1.snapId-p2.snapId));
        this.snapId = 0;
    }

    public void set(int index, int val) {
        Pair pair = new Pair(val,snapId);
        Pair prevPair = map.get(index).floor(pair);
        if(prevPair!=null && pair.snapId == prevPair.snapId) map.get(index).remove(prevPair);
        map.get(index).add(pair);
        
    }

    public int snap() {
        snapId++;
        return this.snapId-1;
    }

    public int get(int index, int sn) {
        Pair pair = map.get(index).floor(new Pair(3490,sn));
        if(pair == null) return 0;
        return pair.element;
    }
}
class Pair{
    int element;
    int snapId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair pair)) return false;
        return snapId == pair.snapId;
    }

    public Pair(int element, int snapId) {
        
        this.element = element;
        this.snapId = snapId;
    }
    @Override
    public String toString() {
        return "Pair{" +
                "element=" + element +
                ", snapId=" + snapId +
                '}';
    }
}
