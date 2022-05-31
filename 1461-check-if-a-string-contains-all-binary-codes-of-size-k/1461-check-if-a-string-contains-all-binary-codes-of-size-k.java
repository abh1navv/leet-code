class Solution {
    public boolean hasAllCodes(String s, int k) {
        int required = (int)Math.pow(2, k);
        Set<Integer> uniques = new HashSet<>();
        int n=0; 
        int bit = 0;
        int len = s.length();
        char ch;
        while(n<len) {
            ch = s.charAt(n);
            bit = bit << 1;
            bit = bit | (ch-'0');
            bit = bit & ~ (1 << k);

            n++;
            //System.out.println(bit);
            if(n>=k) {
                uniques.add(bit);
            }
        }
        
        
        return uniques.size() == required;
    }
}