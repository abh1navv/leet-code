class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> charList= List.of("","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        
        if(digits.length() == 0) return new ArrayList<>();
        
        LinkedList<String> queue=new LinkedList<>();
        
        int curr=0;
    
        String currString = charList.get(digits.charAt(curr)-'1');
        for(int i=0;i<currString.length();i++) {
            queue.add(String.valueOf(currString.charAt(i)));
        }
        
        for(int i=1;i<digits.length();i++) {
            int len=queue.size();
            while(len>0) {
                String prevString = queue.remove();
                currString = charList.get(digits.charAt(i)-'1');
                for(int j=0;j<currString.length();j++) {
                    queue.add(prevString + String.valueOf(currString.charAt(j)));
                }
                len--;
            }
        }
        
        return queue;
    }
}