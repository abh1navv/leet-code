class Solution {
    public String getSmallestString(int n, int k) {
        char[] sb = new char[n];
        int value = 0, maxPossible;
        while(value != k && n!=0) {
            maxPossible  = Math.min(k-n, 25);
            //System.out.println(maxPossible+":"+k+":"+n);
            k-=maxPossible+1;
            n--;
            sb[n] = (char)(maxPossible+'a');
        }
        
        return String.valueOf(sb);
    }
}