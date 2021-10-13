class Solution {
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
    	if(sentence1.equals(sentence2)) return true;
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        if(arr1.length==arr2.length) return false;
        if(arr1.length>arr2.length) return areSentence(arr1,arr2);
        return areSentence(arr2,arr1);
    }
    public static boolean areSentence(String[] arr1, String[] arr2) {
    	int i=0;
    	int count = 0;
    	while(i<arr2.length && arr1[i].equals(arr2[i])) i++;
    	if(i==arr2.length) return true;
    	int j = arr2.length - 1;
    	int k = arr1.length - 1;
    	while(j >=0 && j>=i && arr1[k].equals(arr2[j])) {
    		k--;
    		j--;
    		count++;
    	}
    	if((count+i)==arr2.length) return true;
    	return false;
    }
}
