class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        List<int[]> a = new LinkedList<>();
        for(int[] p: people) {
            a.add(p[1],p);
        }
        return  a.toArray(new int[people.length][2]);
    }
}
