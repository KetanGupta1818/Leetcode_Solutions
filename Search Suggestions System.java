class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for(String prod: products) trie.insert(prod);
        List<List<String>> answer = new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            String prefix = searchWord.substring(0,i+1);
            List<String> list = new ArrayList<>();
            TrieNode node = trie.startsWith(prefix);
            if(node != null){
                trie.loadWords(list,new StringBuffer(prefix),node);
            }
            answer.add(list.subList(0,Math.min(3,list.size())));
        }
        return answer;
    }
}
class TrieNode{
     TreeMap<Character,TrieNode> children;
    private boolean end;

    public TrieNode(){
        this.children = new TreeMap<>((a,b)->a-b);
    }

    public boolean hasLinkToCharacter(char c){
        return children.containsKey(c);
    }

    public TrieNode getLinkToCharacter(char c){
        return children.get(c);
    }

    public void putLinkToCharacter(char c){
        children.put(c,new TrieNode());
    }

    public boolean isEnd(){
        return end;
    }

    public void setEnd(){
        end = true;
    }
}

class Trie{
     TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char cur = word.charAt(i);
            if(!node.hasLinkToCharacter(cur)){
                node.putLinkToCharacter(cur);
            }
            node = node.getLinkToCharacter(cur);
        }
        node.setEnd();
    }

    private TrieNode prefixChecker(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char cur = word.charAt(i);
            if(!node.hasLinkToCharacter(cur)) return null;
            node = node.getLinkToCharacter(cur);
        }
        return node;
    }
    public TrieNode startsWith(String word){
        return prefixChecker(word);
    }
    public void loadWords(List<String> words, StringBuffer sb,TrieNode node){
        if(node.isEnd()){
            words.add(sb.toString());
        }
        for(char c: node.children.keySet()) {
            sb.append(c);
            loadWords(words,sb,node.getLinkToCharacter(c));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
