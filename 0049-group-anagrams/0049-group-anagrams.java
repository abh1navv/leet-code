class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortAndGroup = new HashMap<>();
        
        for(String str: strs) {
            String sorted = Stream.of(str.split(""))
                .sorted()
                .collect(Collectors.joining());
            List<String> prev = sortAndGroup.getOrDefault(sorted, new ArrayList<>());
            prev.add(str);
            sortAndGroup.put(sorted, prev);
            
        }
        
        return sortAndGroup.values().stream().toList();
    }
        
}