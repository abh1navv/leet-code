class Trie {

    Node startNode;
    public Trie() {
        startNode = new Node(' ');
    }
    
    public void insert(String word) {
        var map = startNode.children;
        
        for(char ch: word.toCharArray()) {
            if(!map.containsKey(ch)) {
                Node newNode = new Node(ch);
                map.put(ch,newNode);
                map = newNode.children;
            } else {
                Node existingNode = map.get(ch);
                map = existingNode.children;
            }
        }
        map.put('0',new Node('0'));
        
    }
    
    public boolean search(String word) {
        var map = startNode.children;

        for(char ch: word.toCharArray()) {
            if(!map.containsKey(ch)) {
                return false;
            } else {
                Node existingNode = map.get(ch);
                map = existingNode.children;
            }
        }
        return map.containsKey('0');
    }
    
    public boolean startsWith(String prefix) {
        var map = startNode.children;

        for(char ch: prefix.toCharArray()) {
            if(!map.containsKey(ch)) {
                return false;
            } else {
                Node existingNode = map.get(ch);
                map = existingNode.children;
            }
        }
        return true;
    }
    
    
    class Node {
        char val;
        Map<Character, Node> children;
        
        Node(Character val) {
            this.val = val;
            children = new HashMap<>();
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */