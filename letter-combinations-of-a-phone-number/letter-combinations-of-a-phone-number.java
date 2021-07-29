class Solution {
    
    String[] charMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> alphaStrings = getStrings(digits);
        return alphaStrings;
    }
    
    public List<String> getStrings(String digits) {
        List<String> strings = new ArrayList<>();
        int len = digits.length();
        if(len <= 0) return strings;
        if(len == 1) {
            char[] chars = charMap[digits.charAt(0) - '0'].toCharArray();
            for(char ch:chars) {
                strings.add(String.valueOf(ch));
            }
            return strings;
        }
        
        List<String> part1 = getStrings(digits.substring(0,len/2));
        List<String> part2 = getStrings(digits.substring(len/2));
        
        for(String s1:part1) {
            for(String s2: part2) {
                strings.add(s1+s2);
            }
        }
        return strings;
    }
}