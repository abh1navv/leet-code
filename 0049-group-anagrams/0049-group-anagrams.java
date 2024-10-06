class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortAndGroup = new HashMap<>();
        
        for(String str: strs) {
            String sorted = getCountString(str);
            List<String> prev = sortAndGroup.getOrDefault(sorted, new ArrayList<>());
            prev.add(str);
            sortAndGroup.put(sorted, prev);
            
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> value: sortAndGroup.values()) {
            ans.add(value);
        }
        
        return ans;
    }
    
    String getCountString(String str) {
        int[] counts = new int[26];
        for(char ch: str.toCharArray()) {
            counts[ch-'a']++;
        }
        
        return Arrays.toString(counts);
    }
        
}