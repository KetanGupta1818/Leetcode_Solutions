class Solution {
    TreeMap<Integer,Integer> map = new TreeMap<>();
    public int goodNodes(TreeNode root) {
        int answer = 0;
        if(root == null) return answer;
        if(map.ceilingKey(root.val+1)==null) answer++;
        map.put(root.val,map.getOrDefault(root.val,0)+1);
         answer += goodNodes(root.left) + goodNodes(root.right);
        map.put(root.val,map.get(root.val)-1);
        if(map.get(root.val) == 0) map.remove(root.val);
        return answer;
    }
}
