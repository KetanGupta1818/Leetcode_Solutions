class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int fp=0, bp=people.length-1, boats=0;
        Arrays.sort(people);
        while(fp<people.length && bp>=0 && fp<=bp){
            if(people[fp]+people[bp]<=limit){
                boats++;
                fp++;
                bp--;
            }
            else{
                boats++;
                bp--;
            }
        }
        return boats;
    }
}
