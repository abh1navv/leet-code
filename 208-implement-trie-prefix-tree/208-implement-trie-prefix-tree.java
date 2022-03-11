class Trie {
    Node top; 
    public Trie() {
        top = new Node('0');;
    }
    
    public void insert(String word) {
        Node current = top;
        char ch;
        int len = word.length();
        int i=0;

        for(; i<len;i++) {
            ch = word.charAt(i);
            if(current.children.containsKey(ch)) {
                current = current.children.get(ch);
            } else {
                break;
            }
        }
        while(i<len) {
            ch = word.charAt(i++);
            current.children.put(ch, new Node(ch));
            current = current.children.get(ch);
        }
        current.children.put('E',new Node('E'));
    }
    
    public boolean search(String word) {
        Node current = top;
        char ch;
        int len = word.length();
        int i=0;

        for(; i<len;i++) {
            ch = word.charAt(i);
            if(current.children.containsKey(ch)) {
                current = current.children.get(ch);
            } else {
                break;
            }
        }
        return i == len && current.children.get('E') != null;
    }
    
    public boolean startsWith(String prefix) {
        Node current = top;
        char ch;
        int len = prefix.length();
        int i=0;
        for(; i<len;i++) {
            ch = prefix.charAt(i);
            if(current.children.containsKey(ch)) {
                current = current.children.get(ch);
            } else {
                break;
            }
        }
        return i == len;
    }
    
    class Node {
        char c;
        Map<Character, Node> children;
        
        Node(char c) {
            this.c = c;
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