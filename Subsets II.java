class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        int maxMask = 1<<n;
        HashSet<MyList> set = new HashSet<>();
        for(int i=0;i<maxMask;i++){
            MyList list = new MyList();
            int mask = i,index=0;
            while(mask!=0){
                if((mask&1)!=0) list.add(nums[index]);
                index++;
                mask=mask>>1;
            }
            set.add(new MyList(list.list));
        }
        return new ArrayList<>(set.stream().map(myList->myList.list).toList());
    }
}
class MyList{
    List<Integer> list;

    public MyList() {
        this.list = new ArrayList<>();
    }

    public void add(int num){
        list.add(num);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyList)) return false;
        MyList myList = (MyList) o;
        if(myList.list.size()!=this.list.size()) return false;
        return new HashSet<>(myList.list).equals(new HashSet<>(this.list));
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Integer integer : list) {
            hash += integer;
        }
        return hash;
    }

    public MyList(List<Integer> list) {
        this.list = list;
    }
}
