class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            Map<Integer,List<Integer>> layerMap = new HashMap<>();
            for(int s=0;s<size;s++){
                Pair p =queue.remove();
                List<Integer> list = layerMap.getOrDefault(p.v,new ArrayList<>());
                list.add(p.node.val);
                layerMap.put(p.v,list);
                if(p.node.left!=null) queue.offer(new Pair(p.node.left,p.v-1));
                if(p.node.right!=null) queue.offer(new Pair(p.node.right,p.v+1));
            }
            for(int key: layerMap.keySet()){
                List<Integer> list = layerMap.get(key);
                list.sort(null);
                List<Integer> mList = map.getOrDefault(key,new ArrayList<>());
                mList.addAll(new ArrayList<>(list));
                map.put(key,mList);
            }
        }
        List<List<Integer>> answer = new ArrayList<>();
        for(int key: map.keySet()){
            answer.add(new ArrayList<>(map.get(key)));
        }
        return answer;
    }
}
class Pair{
    TreeNode node;
    int v;
    
    public Pair(TreeNode node, int v){
        this.node = node;
        this.v = v;
    }
}
