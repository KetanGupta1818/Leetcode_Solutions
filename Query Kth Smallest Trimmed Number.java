class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int lengthOfEachNumber = nums[0].length(); //Maximum number of digts
        List<List<String[]>> list = new ArrayList<>();//Contains sorted list of all numbers of a particular number of digits
        list.add(new ArrayList<>()); //There will be no number with number of digits 0.
        for(int digits=1;digits<=lengthOfEachNumber;digits++){
            List<String> numbers = new ArrayList<>();
            for(String num : nums) numbers.add(num.substring(lengthOfEachNumber - digits));
            list.add(fun(numbers));
        }
        int[] answer = new int[queries.length];
        int i = 0;
        for(int[] q: queries)
            answer[i++] = Integer.parseInt(list.get(q[1]).get(q[0]-1)[1]);
        return answer;
    }
    //Returns a sorted list of String[number,index] 
    private List<String[]> fun(List<String> numbers){
        List<String[]> list = new ArrayList<>();
        for(int i=0;i<numbers.size();i++){
            list.add(new String[]{numbers.get(i),Integer.toString(i)});
        }
        list.sort((num1,num2)->{
            int i=0;
            for(i=0;i<num1[0].length();i++){
                if(num1[0].charAt(i) != num2[0].charAt(i)) break;
            }
            if(i == num1[0].length()) return Integer.parseInt(num1[1]) - Integer.parseInt(num2[1]);
            return (num1[0].charAt(i)-'0') - (num2[0].charAt(i) - '0');
        });
        
		return list;
    }
}
