class Solution {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        
        Map<Character,String> charMap = new HashMap<>();
        charMap.put('2',"abc");
        charMap.put('3',"def");
        charMap.put('4',"ghi");
        charMap.put('5',"jkl");
        charMap.put('6',"mno");
        charMap.put('7',"pqrs");
        charMap.put('8',"tuv");
        charMap.put('9',"wxyz");
        
        
        List<String> alphaStrings = new LinkedList<>();
        for(int i=0;i<len;i++) {
            char ch = digits.charAt(i);
            List<String> newList = new ArrayList<>();
            char[] chars = charMap.get(ch).toCharArray();
            if(alphaStrings.isEmpty()) {
                for(char c: chars) {
                    alphaStrings.add(String.valueOf(c));
                }
            } else {
                Iterator<String> iter = alphaStrings.iterator();
                
                while(iter.hasNext()) {
                    String curr = iter.next();
                    for(char c: chars) {
                        newList.add(curr + c);
                    }
                }
                alphaStrings.clear();
                alphaStrings = newList;
            }
        }
        return alphaStrings;
    }
}