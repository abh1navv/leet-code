class Solution {
    public int repeatedStringMatch(String a, String b) {
        int alen = a.length(), count=0;
        int blen = b.length();
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while(len < blen) {
            sb.append(a);
            len+=alen;
            count++;
        }
        if(sb.toString().contains(b)) return count;
        if(sb.append(a).toString().contains(b)) return ++count;
        return -1;
    }
    
}