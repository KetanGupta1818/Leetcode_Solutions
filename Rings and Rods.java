class Solution {
    public int countPoints(String rings) {
        Set<Integer> red = new HashSet<>();
        Set<Integer> blue = new HashSet<>();
        Set<Integer> green = new HashSet<>();
        for(int i=0;i<rings.length();i=i+2){
            char color = rings.charAt(i);
            int position = rings.charAt(i+1)-'0';
            if(color=='R') red.add(position);
            else if(color=='B') blue.add(position);
            else green.add(position);
        }
        red.retainAll(blue);
        red.retainAll(green);
        return red.size();
    }
}
