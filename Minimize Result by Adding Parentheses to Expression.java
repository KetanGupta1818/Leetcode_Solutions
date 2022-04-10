class Solution {
    public String minimizeResult(String expression) {
        TreeMap<Integer,String> map = new TreeMap<>();
        int partition = 0;
        while(partition<expression.length()){
            if(expression.charAt(partition)!='+') partition++;
            else break;
        }
        for(int i=0;i<partition;i++){
            for(int j=expression.length()-1;j>partition;j--){
                int multiplier = 1;
                if(j!=expression.length()-1) multiplier *= Integer.parseInt(expression.substring(j+1));
                if(i!=0) multiplier *= Integer.parseInt(expression.substring(0,i));
                int adder = Integer.parseInt(expression.substring(i,partition)) +
                        Integer.parseInt(expression.substring(partition+1,j+1));
                int number = adder*multiplier;
                if(!map.containsKey(number))
                    map.put(number,expression.substring(0,i)+"("+expression.substring(i,j+1)+")"+expression.substring(j+1));
            }
        }
        return map.get(map.firstKey());
    }
}
