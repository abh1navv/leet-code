class Solution {
    public String customSortString(String order, String s) {
        List<Character> chArr = new ArrayList<>();
        
        for(char c: s.toCharArray()) {
            chArr.add(c);
        }
        
        Collections.sort(chArr, (a, b) -> order.indexOf(a)-order.indexOf(b));
        
        StringBuilder sb = new StringBuilder();
        
        for(Character c: chArr) {
            sb.append(c);
        }
        
        return sb.toString();
    }
    
}