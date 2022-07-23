class NumberContainers {

    Map<Integer,List<Integer>> mapOfValues;
    Map<Integer,Integer> indexToValueMap;
    public NumberContainers() {
        mapOfValues = new HashMap<>();
        indexToValueMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if(indexToValueMap.containsKey(index)){
            int prevNumber = indexToValueMap.get(index);
            List<Integer> listOfIndex = mapOfValues.get(prevNumber);
            int removeIndex = searchInsert(listOfIndex,index);
            int tester1 = listOfIndex.remove(removeIndex);
            if(listOfIndex.size()==0) mapOfValues.remove(prevNumber);
            else mapOfValues.put(prevNumber,listOfIndex);
        }
        indexToValueMap.put(index,number);
        List<Integer> indices = mapOfValues.getOrDefault(number,new ArrayList<>());
        int addIndex = searchInsert(indices,index);
        if(addIndex==indices.size()) indices.add(index);
        else indices.add(addIndex,index);
        mapOfValues.put(number,indices);
    }

    public int find(int number) {
        if(!mapOfValues.containsKey(number)) return -1;
        else return mapOfValues.get(number).get(0);
    }
    private int searchInsert(List<Integer> nums, int target) {
        int lo=0,hi=nums.size()-1;
        while(lo<=hi){
            int m=lo+(hi-lo)/2;
            if(nums.get(m) ==target) return m;
            if(nums.get(m) >target) hi=m-1;
            else lo=m+1;
        }
        return lo;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
