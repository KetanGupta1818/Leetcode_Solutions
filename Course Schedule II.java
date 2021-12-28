class Solution {
     public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] answer = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        if(numCourses==1) return answer;
        Queue<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adjacencyList.add(new ArrayList<>());
        int[] inDegrees = new int[numCourses];
        for(int[] prerequisite: prerequisites){
            inDegrees[prerequisite[0]]++;
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        }
        for(int i=0;i<inDegrees.length;i++){
            if(inDegrees[i]==0){
               queue.offer(i);
            ans.add(i); 
            } 
        }
        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            List<Integer> adjacentList = adjacencyList.get(currentCourse);
            for(int course: adjacentList){
                inDegrees[course]--;
                if(inDegrees[course]==0){
                    queue.offer(course);
                    if(!ans.contains(course))
                    ans.add(course);
                }
            }
        }
        if(ans.size()!=numCourses) return new int[]{};
        for(int i=0;i<numCourses;i++){
            answer[i] = ans.get(i);
        }
       return answer;
    }
}
