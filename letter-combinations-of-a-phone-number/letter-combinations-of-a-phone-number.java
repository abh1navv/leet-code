class Solution {
    Map<Character,String> charMap = new HashMap<>();
    {   
        charMap.put('2',"abc");
        charMap.put('3',"def");
        charMap.put('4',"ghi");
        charMap.put('5',"jkl");
        charMap.put('6',"mno");
        charMap.put('7',"pqrs");
        charMap.put('8',"tuv");
        charMap.put('9',"wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        
        if(len==0) return new ArrayList<>();
        
        List<String> alphaStrings = getStrings(digits);
            //getAlphaStrings(digits.toCharArray(),0, "");
//         for(int i=0;i<len;i++) {
//             char ch = digits.charAt(i);
//             List<String> newList = new ArrayList<>();
//             char[] chars = charMap.get(ch).toCharArray();
//             if(alphaStrings.isEmpty()) {
//                 for(char c: chars) {
//                     alphaStrings.add(String.valueOf(c));
//                 }
//             } else {
//                 Iterator<String> iter = alphaStrings.iterator();
                
//                 while(iter.hasNext()) {
//                     String curr = iter.next();
//                     for(char c: chars) {
//                         newList.add(curr + c);
//                     }
//                 }
//                 //alphaStrings.clear();
//                 alphaStrings = newList;
//             }
//         }
        return alphaStrings;
    }
    
    public List<String> getAlphaStrings(char[] chars, int index, String start) {
        List<String> alphaStrings = new ArrayList<>(); 

        if(index == chars.length) {
            alphaStrings.add(start);
            return alphaStrings;
        }
        char c = chars[index];
        
        char[] newChars = charMap.get(c).toCharArray();
        //System.out.println(newChars);
        for(char ch: newChars) {
            List<String> tempList = getAlphaStrings(chars, index+1, start+ch);
          //  System.out.println(tempList);
            alphaStrings.addAll(tempList);
        }
        return alphaStrings;
    }
    
    public List<String> getStrings(String digits) {
        List<String> strings = new ArrayList<>();
        int len = digits.length();
        if(len <= 0) return strings;
        if(len == 1) {
            char[] chars = charMap.get(digits.charAt(0)).toCharArray();
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