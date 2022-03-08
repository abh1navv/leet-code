class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] tree = preorder.split(",");
        int diff = 1;
        
        for(String c: tree) {
            if(--diff < 0) return false;
            if(!c.equals("#")) diff+=2;
        }
        return diff == 0;
    }
}