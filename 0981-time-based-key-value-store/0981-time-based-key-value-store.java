class TimeMap {

    Map<String, List<Object[]>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        var curr= map.getOrDefault(key, new ArrayList<>());
        curr.add(new Object[]{timestamp, value});
        map.put(key, curr);
    }
    
    public String get(String key, int timestamp) {
        var curr= map.getOrDefault(key, null);
        if(curr == null) return "";
        
        return getValue(curr, timestamp);
    }
    
    private String getValue(List<Object[]> keys, int time) {
        int low = 0, high = keys.size() - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if ((int)keys.get(mid)[0] == time) return (String)keys.get(mid)[1];
            if ((int)keys.get(mid)[0] < time) {
                if ((int)keys.get(mid+1)[0] > time) return (String)keys.get(mid)[1];
                low = mid + 1;
            }
            else high = mid -1;
        }
        
        return   (int)keys.get(low)[0] <= time ? (String)keys.get(low)[1] : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */