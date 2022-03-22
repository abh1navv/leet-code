class Solution {
    public String getSmallestString(int n, int k) {
        char[] sb = new char[n];
        int maxPossible;
        while(0 != k) {
            maxPossible  = Math.min(k-n, 25);
            k-=maxPossible+1;
            n--;
            sb[n] = (char)(maxPossible+'a');
        }
        
        return String.valueOf(sb);
    }
}