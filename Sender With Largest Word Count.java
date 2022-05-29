class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<messages.length;i++){
            int len = messages[i].split(" ").length;
            map.put(senders[i],map.getOrDefault(senders[i],0)+len);
        }
        int max_len = 0;
        String answer = messages[0];
        for(String person: map.keySet()){
            int words = map.get(person);
            if(max_len<words || (max_len==words && person.compareTo(answer)>0)) {
                max_len = words;
                answer = person;
            }
        }
        return answer;
    }
}
