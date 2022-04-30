class Solution {
    Map<String,Double> stringToVertexMap = new HashMap<>();
    double[] answers;
    int indexOfAnswer = -1;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double n = 0;
        for(List<String> equation: equations){
            if(!stringToVertexMap.containsKey(equation.get(0))) stringToVertexMap.put(equation.get(0),n++);
            if(!stringToVertexMap.containsKey(equation.get(1))) stringToVertexMap.put(equation.get(1),n++);
        }
        answers = new double[queries.size()];
        Arrays.fill(answers,-1d);
        List<List<double[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<equations.size();i++){
            List<String> equation = equations.get(i);
            double vertex1 = stringToVertexMap.get(equation.get(0));
            double vertex2 = stringToVertexMap.get(equation.get(1));
            graph.get((int)vertex1).add(new double[]{vertex2,values[i]});
            graph.get((int)vertex2).add(new double[]{vertex1,1/values[i]});
        }
        for(int index=0;index<queries.size();index++){
            String sourceString = queries.get(index).get(0);
            String targetString = queries.get(index).get(1);
            indexOfAnswer++;
            if(!stringToVertexMap.containsKey(sourceString) || !stringToVertexMap.containsKey(targetString)) continue;
            double source = stringToVertexMap.get(sourceString);
            double target = stringToVertexMap.get(targetString);
            boolean[] visited = new boolean[(int)n];
            visited[(int)source] = true;
            dfs((int)source,(int)target,graph,visited,1d);

        }
        return answers;
    }
    private void dfs(int source, int target, List<List<double[]>> graph, boolean[] visited, double cur_weight){
        if(source==target) {
            answers[indexOfAnswer] = cur_weight;
            return;
        }
        for(double[] edge: graph.get(source)){
            int next = (int)edge[0];
            double weight = edge[1];
            if(!visited[next]){
                visited[next] = true;
                dfs(next,target,graph,visited,cur_weight*weight);
            }
        }
    }
}
