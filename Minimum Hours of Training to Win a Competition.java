class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = 0;
        for(int e: energy) sum += e;
        int answer = 0;
        if(sum>=initialEnergy) answer += sum-initialEnergy+1;
        for(int e: experience){
            if(e>=initialExperience){
                answer += e-initialExperience+1;
                initialExperience = 2*e+1;
            }
            else initialExperience += e;
        }
        return answer;
    }
}
