class Solution {
    public boolean hasAllCodes(String s, int k) {
        int required = (int)Math.pow(2, k);
        Set<String> uniqueStrings = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int n=0; 
        int len = s.length();
        while(n<k && n<len) {
            sb.append(s.charAt(n++));
        }
        
        uniqueStrings.add(sb.toString());
        
        for(;n<len;n++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(n));
            uniqueStrings.add(sb.toString());
        }
        
        return uniqueStrings.size() == required;
    }
}