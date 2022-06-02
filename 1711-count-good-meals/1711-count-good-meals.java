class Solution {
    public int countPairs(int[] del) {
        int len = del.length;
        if(len<2) return 0; 
        
        int count = 0;
        Arrays.sort(del);
        Map<Integer, Integer> countsMap = new HashMap<>();
        for(int i: del) {
            countsMap.put(i, countsMap.getOrDefault(i, 0)+1);
        }
        
        int maxPossible = del[len-1]+del[len-2];
        maxPossible = (int)(Math.floor(Math.pow(2,(int)(Math.log(maxPossible)/Math.log(2)))));
        
        for(int i=maxPossible; i>=1; i=i>>1) {
            count+= countOccur(del,i, countsMap)%1000000007;
        }
        return count;
    }
    
    int countOccur(int[] del, int k, Map<Integer, Integer> countsMap) {
        int i=0, j=del.length-1, count=0;
        while(i<j) {
            int sum = del[i]+del[j];
            if(sum == k) {                
                if(del[i]!=del[j]) {
                    count+= (countsMap.get(del[i])*countsMap.get(del[j]))%1000000007;
                } else {
                    int curr = countsMap.get(del[i]);
                    int second = curr-1;
                    int index = 0;
                    if(curr%2 != 0) {
                        curr = second;
                        second = curr+1;
                    } 
                    for(int x=0; x<second; x++) {
                        count = (count+ curr/2)%1000000007;
                    }
                }
                
                while(i<j && del[i+1]==del[i]) i++;
                while(j>0 && del[j-1]==del[j]) j--;
                
                i++;
                j--;
            }
            else if(sum<k) i++;
            else j--;
        }
        
        return count;
    }
}