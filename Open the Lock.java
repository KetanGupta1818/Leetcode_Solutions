class Solution {
    public int openLock(String[] deadEnds, String target) {
        HashSet<String> inValidCodes = new HashSet<>(Arrays.asList(deadEnds));
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        if(inValidCodes.contains("0000") || inValidCodes.contains(target)) return -1;
        int levels = 0;
        queue.offer("0000");
        visited.add("0000");
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s=0;s<size;s++){
                String code = queue.remove();
                if(code.equals(target)) return levels;
                for(int i=0;i<4;i++){
                    int c = code.charAt(i)-'0';
                    int prev = c==0?9:c-1;
                    int forward = c==9?0:c+1;
                    String previousCode = code.substring(0,i)+ (char) (prev + 48) +code.substring(i+1);
                    String forwardCode = code.substring(0,i)+ (char) (forward + 48) +code.substring(i+1);
                    if(!visited.contains(previousCode) && !inValidCodes.contains(previousCode)){
                        queue.offer(previousCode);
                        visited.add(previousCode);
                    }
                    if(!visited.contains(forwardCode) && !inValidCodes.contains(forwardCode)){
                        queue.offer(forwardCode);
                        visited.add(forwardCode);
                    }
                }
            }
            levels++;
        }
        return -1;
    }
}
