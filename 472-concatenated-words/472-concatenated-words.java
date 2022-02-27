class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (w1, w2) -> (w1.length() - w2.length()));
        List<String> ans = new LinkedList<>();
        Set<String> dict = new HashSet<>();
        for (String w : words) {
            int bit = 0;
            bit = bit | 1;
            for (int i = 1; i <= w.length(); i++) {
                for (int j = i; j > -1; j--) {
                    if (((bit & (1 << j)) != 0) && dict.contains(w.substring(j, i))) {
                        bit = bit | (1 << i);
                        break;
                    }
                }
            }
            if (w.length() > 0 && ((bit & (1 << w.length())) != 0)) ans.add(w);
            dict.add(w);
        }
        return ans;
    }
    
}