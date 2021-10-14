class Solution {
    public int findKthLargest(int[] nums, int k) {
        Heap h = new Heap(nums);
        for(int i=0;i<h.arr.size();i++) h.percolate_up(i);
        for(int j=0;j<k-1;j++) h.delete();
        return h.delete();
    }
}
class Heap{
	List<Integer> arr;
	int count;
	public Heap(int[] nums) {
		this.arr = new ArrayList<>();
		for(int i=0;i<nums.length;i++) this.arr.add(nums[i]);
	}
	public int parent(int i) {
		if(i<0 || i>=this.arr.size()) return -1;
		return (i-1)/2;
	}
	public int left_child(int i) {
		int lc = 2*i+1;
		if(lc<=0 || lc>=this.arr.size()) return -1;
		return lc;
	}
	public int right_child(int i) {
		int rc = 2*i+2;
		if(rc<=0 || rc>=this.arr.size()) return -1;
		return rc;
	}
	public void percolate_up(int i) {
		if(i<=0) return;
		int p = this.parent(i);
		if(this.arr.get(p)<this.arr.get(i)) {
			Collections.swap(arr, i, p);
			this.percolate_up(p);
		}
	}
	public void percolate_down(int i) {
		if(i>=this.arr.size()) return;
		int valleft=Integer.MIN_VALUE, valright=Integer.MIN_VALUE;
		int cl = this.left_child(i);
		if(cl!=-1 && this.arr.get(i)<this.arr.get(cl)) {
			valleft = this.arr.get(cl);
		}
		else cl = -1;
		int cr = this.right_child(i);
		if(cr!=-1 && this.arr.get(i)<this.arr.get(cr)) {
			valright = this.arr.get(cr);
		}
		else cr = -1;
		if(cl == -1 && cr == -1) return ;
		else if(cl==-1 && cr!=-1) {
			Collections.swap(arr, cr, i);
			percolate_down(cr);
		}
		else if(cl!=-1 && cr == 1) {
			Collections.swap(arr, cl, i);
			percolate_down(cl);
		}
		else {
			if(valright>valleft) {
				Collections.swap(arr, cr, i);
				percolate_down(cr);
			}
			else {
				Collections.swap(arr, cl, i);
				percolate_down(cl);
			}
		}
	}
	public int delete() {
		if(arr.size()<=0) return -1;
		int data = this.arr.get(0);
		Collections.swap(arr, 0, arr.size()-1);
		this.arr.remove(arr.size()-1);
		this.percolate_down(0);
		return data;
	}
}
