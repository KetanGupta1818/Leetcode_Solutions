class TopVotedCandidate {
    Map<Integer,Integer> freq ;
    TreeSet<Range> treeSet;
    public TopVotedCandidate(int[] persons, int[] times) {
        int mostFreq = -1;
        freq = new HashMap<>();
        treeSet = new TreeSet<>(Comparator.comparingInt(r -> r.left));
        freq.put(-1,-1);
        for(int i=0;i<persons.length;i++){
            freq.put(persons[i],freq.getOrDefault(persons[i],0)+1);
            if(freq.get(mostFreq)<=freq.get(persons[i])) mostFreq = persons[i];
            if(i!=persons.length-1) treeSet.add(new Range(times[i],times[i]-1,mostFreq));
            else treeSet.add(new Range(times[i],Integer.MAX_VALUE,mostFreq));
        }
    }

    public int q(int t) {
        return treeSet.floor(new Range(t,Integer.MAX_VALUE,-1)).mostVotedPerson;
    }
}
class Range{
    int left;
    int right;
    int mostVotedPerson;
    public Range(int left, int right,int mostVotedPerson) {
        this.left = left;
        this.right = right;
        this.mostVotedPerson = mostVotedPerson;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
