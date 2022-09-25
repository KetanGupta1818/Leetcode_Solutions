class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Queue<Pair> queue = new PriorityQueue<>((p1,p2)->p2.height-p1.height);
        for(int i=0;i<names.length;i++) queue.offer(new Pair(names[i],heights[i]));
        String[] res = new String[names.length];
        for(int i=0;i<names.length;i++) res[i] = queue.remove().name;
        return res;
    }

}
class Pair{
    String name;
    int height;

    public Pair(String name, int height) {
        this.name = name;
        this.height = height;
    }
}
