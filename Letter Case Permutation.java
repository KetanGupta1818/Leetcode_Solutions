class Solution {
   public List<String> letterCasePermutation(String s) {
        Queue<String> queue = new ArrayDeque<>();
        if(s.length() == 0) return new ArrayList<>(queue);
        queue.offer(s);
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))) continue;
            int size = queue.size();
            for(int j=0;j<size;j++){
                String chars = queue.poll();
                char[] arrOChar = chars.toCharArray();
                arrOChar[i] = Character.toUpperCase(arrOChar[i]);
                String upString = new String(arrOChar);
                queue.offer(upString);
                arrOChar[i] = Character.toLowerCase(arrOChar[i]);
                String lowString = new String(arrOChar);
                queue.offer(lowString);
            }
        }
        return new ArrayList<>(queue);
    }
}
