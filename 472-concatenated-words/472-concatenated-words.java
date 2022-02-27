class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (w1, w2) -> (w1.length() - w2.length()));
        List<String> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String w : words) {
            boolean[] dp = new boolean[w.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= w.length(); i++) {
                for (int j = i; j > -1; j--) {
                    if (dp[j] && dict.contains(w.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (w.length() > 0 && dp[w.length()]) ans.add(w);
            dict.add(w);
        }
        return ans;
    }
}