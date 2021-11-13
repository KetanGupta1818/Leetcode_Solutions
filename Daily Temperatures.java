class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int currDay=0;currDay<n;currDay++){
            int currentTemp = temperatures[currDay];
            while(!stack.isEmpty() && temperatures[stack.peek()]<currentTemp){
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
        return answer;
    }
}
/* 
* This is a very good Question
* Monotonic stack: A monotonic stack is a normal stack which stores data in increasing or decreasing order. In this case we will be storing data in decreasing order.
* We will create a decreasing stack which stores index of temperatures rather than storing temperatures because we need number of days as answer. 
* If stack is Empty push the index of that element on to the stack and iterate forward. 
* if current temperature is less than or equal to the top element then push current element into stack because this temperature would not affect the decreasing order of stack.
* Else: current temperature is warmer than the temperture index at the top of stack. Its time to update answer array. answer[prevDay] = curDay - prevDay. 
* Also remember to pop prevDay from stack. 
* In all cases we have to push current Index into stack. 
* Finally return answer array. 
*/
//We succesfully solved a very good problem on monotonic stack. 
//Thank you <:-)
