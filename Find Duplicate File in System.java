class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map = new HashMap<>();
        for(String path: paths){
            String[] arr = path.split(" ");
            for(int i=1;i<arr.length;i++){
                String fileContent = arr[i].substring(arr[i].indexOf('('),arr[i].indexOf(')'));
                String directory = arr[0]+"/"+arr[i].substring(0,arr[i].indexOf('('));
                List<String> list = map.getOrDefault(fileContent,new ArrayList<>());
                list.add(directory);
                map.put(fileContent,list);
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for(String fileContent: map.keySet()){
            if(map.get(fileContent).size()>1) answer.add(map.get(fileContent));
        }
        return answer;
    }
}
