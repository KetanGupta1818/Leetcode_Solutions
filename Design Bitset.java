class Bitset {
    private final int size;
    private Set<Integer> ones = new HashSet<>();
    private Set<Integer> zeros = new HashSet<>();
    public Bitset(int size) {
        this.size = size;
        for(int i=0;i<size;i++) zeros.add(i);
    }

    public void fix(int idx) {
        zeros.remove(idx);
        ones.add(idx);
    }

    public void unfix(int idx) {
        zeros.add(idx);
        ones.remove(idx);
    }

    public void flip() {
        Set<Integer> temp = ones;
        ones = zeros;
        zeros = temp;
    }

    public boolean all() {
        return ones.size()==size;
    }

    public boolean one() {
        return ones.size()>0;
    }

    public int count() {
        return ones.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++){
            if(ones.contains(i)) sb.append("1");
            else sb.append("0");
        }
        return sb.toString();
    }
}
