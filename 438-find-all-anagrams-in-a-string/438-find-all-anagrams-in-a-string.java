class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int plen = p.length();
        int slen = s.length();
        if(plen > slen) {
            return new ArrayList<>();
        }
        int[] count = new int[26];
        int[] slidingCount = new int[26];
        
        for(int i=0; i<p.length();i++) {
            count[p.charAt(i)-'a']++;
        }
        
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        for(int i=0;i<slen;i++) {
            slidingCount[s.charAt(i)-'a']++;
            
            if(i>=plen+start-1) {
                if(Arrays.equals(count, slidingCount)) {
                    ans.add(start);
                } 
                slidingCount[s.charAt(start)-'a']--;
                start+=1;
            }
        }
        
        return ans;
    }
    

}