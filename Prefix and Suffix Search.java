class WordFilter {
    private final Trie trie;
    public WordFilter(String[] words) {
        this.trie = new Trie();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            for(int j=0;j<=word.length();j++){
                trie.insert(word.substring(j)+'{'+word,i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return trie.startsWith(suffix+"{"+prefix);
    }
}
class TrieNode{
    private final Map<Character,TrieNode> children;
    private boolean end;
    int weight;
    public TrieNode(){
        this.children = new HashMap<>();
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
    private TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word,int weight){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char cur = word.charAt(i);
            node.weight = weight;
            if(!node.hasLinkToCharacter(cur)){
                node.putLinkToCharacter(cur);
            }
            node = node.getLinkToCharacter(cur);
        }
        node.weight = weight;
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

    public int startsWith(String word){
        TrieNode node = prefixChecker(word);
       if(node == null) return -1;
       return node.weight;
    }
}
