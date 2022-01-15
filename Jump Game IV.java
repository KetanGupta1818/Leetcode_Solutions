class Solution {
   public int minJumps(int[] arr) {
        int n = arr.length;
        if(n==1) return 0;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            List<Integer> list = null;
            if(map.containsKey(arr[i]))
                list = map.get(arr[i]);
            else list = new ArrayList<>();
            list.add(i);
            map.put(arr[i],list);
        }
        //System.out.println(map);
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> firstList = map.get(arr[0]);
        boolean[] visited = new boolean[n];
        for(int index: firstList){
            if(index==0) continue;
            visited[index] = true;
            queue.offer(index);
        }
        queue.offer(1);

        visited[1] = true;
        visited[0] = true;
        int steps = 1;
        //System.out.println(queue);
        while(!visited[n-1]){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int currIndex = queue.poll();
                //if(visited[currIndex]) continue;
                if(!visited[currIndex-1]){
                    visited[currIndex-1] = true;
                    queue.offer(currIndex-1);
                }
                if(!visited[currIndex+1]){
                    visited[currIndex+1] = true;
                    queue.offer(currIndex+1);
                }
                List<Integer> list = map.get(arr[currIndex]);
                for(int index: list){
                    if(!visited[index]){
                        visited[index] = true;
                        queue.offer(index);
                    }
                }
                map.get(arr[currIndex]).clear();
            }
            steps++;
        }
        return steps;
    }
}
