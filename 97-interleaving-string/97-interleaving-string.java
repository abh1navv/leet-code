class Solution {
    Map<String, Boolean> cache = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length()-1;
        int l2 = s2.length()-1;
        int l3 = s3.length()-1;

        return checkIL(s1, l1, s2, l2, s3, l3);
    }
    
    boolean checkIL(String s1, int l1, String s2, int l2, String s3, int l3) {
        String key = l1+""+l2+""+l3;
        if(cache.containsKey(key)) {
            //System.out.println("Cache hit");
            return cache.get(key);
        }
        
        while((l1>=0 || l2>=0) && l3>=0) {
            char curr = s3.charAt(l3);
            char curr1 = l1>=0 ? s1.charAt(l1): 'X';
            char curr2 = l2>=0 ? s2.charAt(l2): 'X';
            if(curr == curr1 && curr != curr2) {
                l1--;
                l3--;
            } else if(curr != curr1 && curr == curr2) {
                l2--;
                l3--;
            } else if(curr != curr1 && curr != curr2) {
                cache.put(key, false);
                return false;
            } else {
                boolean first = checkIL(s1, l1-1, s2, l2, s3, l3-1); 
                boolean second = checkIL(s1, l1, s2, l2-1, s3, l3-1);
                cache.put(key, first || second);

                return first || second;
            }
        }
        boolean result = l1 == -1 && l2 == -1 && l3 == -1;
        cache.put(key, result);
        return result;
    }
}