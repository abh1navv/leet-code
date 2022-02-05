class Solution {
    public boolean checkInclusion(String s1, String s2) {
    int len1 = s1.length(), len2 = s2.length();
    if (len1 > len2) return false;
    
    Map<Character, Integer> map = new HashMap<>();
    int size = 0;
    for (int i = 0; i < len1; i++) {
        char ch = s1.charAt(i);
        Integer x = map.get(ch);
        if(x!=null) map.put(ch, x+1);
        else {
            map.put(ch,1);
            size++;
        }
    }
    
    for (int i = 0; i < len2; i++) {
        char ch = s2.charAt(i);
        Integer x = map.get(ch);

        if(x!=null && x!=0) {
            if(x==1) {
                size--;
                map.put(ch, 0);
            } 
            else map.put(ch, x-1);
        }
        else {
            size++;
            map.put(ch,-1);
        }
        
        if(i - len1 >= 0) {
            ch = s2.charAt(i-len1);
            x = map.get(ch);
            if(x!=null && x!=0) {
                if(x==-1) {
                    size--;
                    map.put(ch, 0);
                } else {
                    map.put(ch, x+1);
                }
            }
            else {
                size++;
                map.put(ch,1);
            }
        }
        
        if (size==0){
            return true;
        }
    }
    
    return false;
}

    private boolean isNull(Map<Character, Integer> map) {
        for(Integer i: map.values()) {
            if(i!=null && i!=0) return false;
        }
        return true;
    }
}