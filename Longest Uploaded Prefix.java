class LUPrefix {
    TreeSet<Integer> set;
    public LUPrefix(int n) {
        this.set = new TreeSet<>();
        for(int i=1;i<=n+1;i++) set.add(i);
    }

    public void upload(int video) {
        set.remove(video);
    }

    public int longest() {
        return set.first()-1;
    }
}
