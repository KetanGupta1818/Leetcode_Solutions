class Solution {
    private static int MOD = 1_000_000_007;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer,Long> map = new HashMap<>();
        for(int a: arr) map.put(a,1L);
        long answer = 0L;
        for(int i=0;i<arr.length;i++){
            updateMap(arr,map,i-1,arr[i]);
            answer = (answer + map.get(arr[i]))%MOD;
        }
        return (int)answer;
    }
    private static void updateMap(int[] arr, Map<Integer,Long> map, int n, int target){
        for(int i=0;i<=n;i++){
            if(target%arr[i] == 0 && map.containsKey(target/arr[i])){
                int second = target/arr[i];
                map.put(target,(map.get(target)+map.get(arr[i])*map.get(second))%MOD);
            }
        }
    }
}
