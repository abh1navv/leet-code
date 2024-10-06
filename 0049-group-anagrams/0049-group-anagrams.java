class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortAndGroup = new HashMap<>();
        
        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            
            String sorted = new String(arr);
            List<String> prev = sortAndGroup.getOrDefault(sorted, new ArrayList<>());
            prev.add(str);
            sortAndGroup.put(sorted, prev);
            
        }
        
        return sortAndGroup.values().stream().toList();
    }
        
}