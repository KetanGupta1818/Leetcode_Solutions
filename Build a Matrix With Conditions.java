class Solution {
     private int rowNumber = 0;
    private int colNumber = 0;
    int[][] assignments;
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        assignments = new int[k][2];
        List<List<Integer>> rowGraph = new ArrayList<>();
        List<List<Integer>> colGraph = new ArrayList<>();
        int[] rowInDegree = new int[k];
        int[] colInDegree = new int[k];
        for(int i=0;i<k;i++){
            rowGraph.add(new ArrayList<>());
            colGraph.add(new ArrayList<>());
        }
        for(int[] rowCondition: rowConditions){
            int u = rowCondition[0]-1;
            int v = rowCondition[1]-1;
            rowGraph.get(u).add(v);
            rowInDegree[v]++;
        }
        for(int[] colCondition: colConditions){
            int u = colCondition[0]-1;
            int v = colCondition[1]-1;
            colGraph.get(u).add(v);
            colInDegree[v]++;
        }
        rowNumber =0 ;
        colNumber=0;
        Queue<Integer> queueRow = new ArrayDeque<>();
        Queue<Integer> queueCol = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            if(colInDegree[i]==0) queueCol.add(i);
            if(rowInDegree[i]==0) queueRow.add(i);
        }
        boolean[] rowVisited = new boolean[k];
        boolean[] colVisited = new boolean[k];
        //If all row and col are not visited that means there is a cycle
        while(!queueRow.isEmpty()){
            int node = queueRow.remove();
            if(!rowVisited[node]) {
                rowVisited[node] = true;
                assignments[node][0] = rowNumber++;
                for(int child: rowGraph.get(node)){
                    rowInDegree[child]--;
                    if(rowInDegree[child]==0){
                        queueRow.offer(child);
                    }
                }
            }
        }
        while(!queueCol.isEmpty()){
            int node = queueCol.remove();
            if(!colVisited[node]){
                colVisited[node] = true;
                assignments[node][1] = colNumber++;
                for(int child: colGraph.get(node)){
                    colInDegree[child]--;
                    if(colInDegree[child]==0){
                        queueCol.offer(child);
                    }
                }
            }
        }
        int[][] answer = new int[k][k];
        for(int i=0;i<k;i++){
            if(!colVisited[i] || !rowVisited[i]) return new int[][] {};
            answer[assignments[i][0]][assignments[i][1]] = i+1;
        }
        return answer;
    }
}
