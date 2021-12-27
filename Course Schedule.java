class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==1) return true;
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adjacentList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjacentList.add(new ArrayList<>());
        }
        for(int[] prerequisite: prerequisites){
            inDegrees[prerequisite[0]]++;
            adjacentList.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDegrees[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            List<Integer> adjacentCourses = adjacentList.get(currentCourse);
            for(int course: adjacentCourses){
                inDegrees[course]--;
                if(inDegrees[course]==0){
                    queue.offer(course);
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(inDegrees[i]>0) return false;
        }
        return true;
    }
}
