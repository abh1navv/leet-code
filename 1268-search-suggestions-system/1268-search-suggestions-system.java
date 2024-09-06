class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        Node root = new Node(' ', new TreeMap<>());
        int i=0;
        for(String product: products) {
            Node curr = root;
            for(char ch: product.toCharArray()) {
                if(!curr.children.containsKey(ch)) {
                    Node newNode = new Node(ch, new TreeMap<>());
                    newNode.index = i;
                    curr.children.put(ch, newNode);
                    curr = newNode;
                } else {
                    curr = curr.children.get(ch);
                }
            }
            curr.end=true;
            i++;
        }
        
        Node curr = root;
        StringBuilder word = new StringBuilder();
        for(char ch: searchWord.toCharArray()) {
            List<String> matches = new ArrayList<>();

            if(curr != null && curr.children.containsKey(ch)) {
                word.append(ch);
                curr = curr.children.get(ch);
            } else {
                curr = null;
                ans.add(matches);
                continue;
            }
            
            int num = 0;
            if(curr.end) {
                matches.add(word.toString());
                num++;
            }
            
            for(int j=num; j<3 && curr.index+j < products.length ;j++) {
                if(word.length() <= products[curr.index+j].length() && products[curr.index+j].substring(0, word.length()).equals(word.toString())) {
                    matches.add(products[curr.index+j]);
                }
            }
            
            ans.add(matches);
        }
        
        return ans;
    }
    

    
    private static class Node {
        boolean end;
        int index;
        char ch;
        TreeMap<Character, Node> children;
        
        Node(char ch, TreeMap<Character, Node> children) {
            this.ch = ch;
            this.children = children;
        }
    }
}