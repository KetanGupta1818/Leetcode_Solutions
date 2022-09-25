class Solution {
    public String fractionAddition(String expression) {
        String[] arr = expression.split("[+-]");
        Queue<Character> q = new ArrayDeque<>();
        if(Character.isDigit(expression.charAt(0))) q.offer('+');
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='-' || c=='+') q.offer(c);
        }
        
        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();
        for(String a: arr){
            if(a.length()<2) continue;
            char c = q.remove();
            String[] res = a.split("/");
            
            numerators.add(Integer.parseInt(res[0])*((c=='-')?-1:1));
            denominators.add(Integer.parseInt(res[1]));
        }
        int[] d = new int[denominators.size()];
        for(int i=0;i<denominators.size();i++) d[i] = denominators.get(i);
        LCM obj = new LCM();
        long lcm = obj.lcmOfArrayWithoutMOD(d);
        long numerator = 0L;
        for(int i=0;i<denominators.size();i++){
            numerator += numerators.get(i)*(lcm/denominators.get(i));
        }
        long gcd = obj.gcd(Math.abs(numerator),lcm);
        numerator=numerator/gcd;
        lcm = lcm/gcd;
        return Long.toString(numerator)+ "/"+Long.toString(lcm);
    }

}
class LCM {
    public long gcd(long a , long b)
    {
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }

    private long lcm(long a , long b)
    {
        return (a*b)/gcd(a,b);
    }

    public long lcmOfArrayWithMOD(int[] A) {
        int N = A.length;
        long ans = 1;
        for (int j : A) ans = lcm(ans, j) % 1000000007;
        return ans;
    }
    public long lcmOfArrayWithoutMOD(int[] A) {
        int N = A.length;
        long ans = 1;
        for (int j : A) ans = lcm(ans, j);
        return ans;
    }
}
