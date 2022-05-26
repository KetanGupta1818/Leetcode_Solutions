class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        for(int[] interval: intervals){
            int left = interval[0];
            int right = interval[1];
            if(end < left){
                list.add(Arrays.asList(start,end));
                start = Integer.MAX_VALUE;
                end = Integer.MAX_VALUE;
            }
            else if(start <= right){
                //System.out.println(Math.max(right,end));
                list.add(Arrays.asList(Math.min(left,start),Math.max(right,end)));
                start = Integer.MAX_VALUE;
                end = Integer.MAX_VALUE;
                continue;
            }
            if(list.size() > 0 && list.get(list.size() - 1).get(1) >= left ) {
                //System.out.println("OHno");
                list.get(list.size()-1).set(1, Math.max(right,list.get(list.size() - 1).get(1)));
            }
            else {
                list.add(Arrays.asList(left,right));
            }
        }
        if(end!=Integer.MAX_VALUE){
            list.add(Arrays.asList(start,end));
        }
        int[][] answer = new int[list.size()][2];
        for(int i=0;i<answer.length;i++){
            answer[i][0] = list.get(i).get(0);
            answer[i][1] = list.get(i).get(1);
        }
        return answer;
    }
}
