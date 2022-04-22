class MyHashMap {
    Bucket[] arr;
    public MyHashMap() {
        arr = new Bucket[1001];
        Arrays.fill(arr, new Bucket());
    }
    
    public void put(int key, int value) {
        int bucket = key/1000;
        arr[bucket].put(key, value);
    }
    
    public int get(int key) {
        int bucket = key/1000;
        return arr[bucket].get(key);
    }
    
    public void remove(int key) {
        int bucket = key/1000;
        arr[bucket].remove(key);
    }
    
    class Bucket {
        List<Integer> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        Bucket(){
        }
        public void put(int key, int value) {
            int i= getKeyIndex(key);
            if(i==-1) {
                keys.add(key);
                values.add(value);
            } else {
                values.set(i, value);
            }
        }
    
        public int get(int key) {
            int i= getKeyIndex(key);
            
            return i == -1? -1: values.get(i);
        }
    
        public void remove(int key) {
            int i= getKeyIndex(key);
            
            if(i != -1) values.set(i, -1);
        }
        
        private Integer getKeyIndex(int key) {
            int index=-1;
            for(int i=0;i<keys.size();i++) {
                if(keys.get(i) == key) {
                    index = i;
                    break;
                }
            }
            
            return index;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */