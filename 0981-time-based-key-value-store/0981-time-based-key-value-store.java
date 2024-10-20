class TimeMap {

    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        var curr= map.getOrDefault(key, new TreeMap<>());
        curr.put(timestamp, value);
        map.put(key, curr);
    }
    
    public String get(String key, int timestamp) {
        var curr= map.getOrDefault(key, null);
        if(curr == null) return "";
        
        return getValue(curr, timestamp);
    }
    
    private String getValue(TreeMap<Integer, String> timestamps, int timestamp) {
        var curr = timestamps.floorEntry(timestamp);
        return curr==null? "": curr.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */