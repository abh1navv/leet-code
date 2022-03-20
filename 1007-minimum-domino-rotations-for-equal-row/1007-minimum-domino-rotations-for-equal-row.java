class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[][] freq = new int[2][7];
        int maxTop=0, maxBot = 0;
        int topVal = 0, botVal=0;
        for(int i=0; i<tops.length; i++) {
            freq[0][tops[i]]++;
            if(freq[0][tops[i]]>topVal) {
                topVal = freq[0][tops[i]];
                maxTop = tops[i];
            }
            freq[1][bottoms[i]]++;
            if(freq[1][bottoms[i]]>botVal) {
                maxBot = bottoms[i];
                botVal = freq[1][bottoms[i]];
            }
        }
        int countTop=0;
        boolean found = true;
        
        // System.out.println(maxTop + ":" + maxBot);
        // System.out.println(Arrays.toString(freq[0]));
        
        for(int i=0; i<tops.length; i++) {
            if(maxTop != tops[i]) {
                if(maxTop == bottoms[i]) {
                    countTop++;
                } else {
                    found = false;
                    break;
                }
            }
        }
        
        if(!found) countTop=-1;
        
        int count=0;
        found=true;
        for(int i=0; i<bottoms.length; i++) {
            if(maxBot != bottoms[i]) {
                if(maxBot == tops[i]) {
                    count++;
                } else {
                    found = false;
                    break;
                }
            }
        }
        if(!found) count=countTop;
        else if(countTop == -1) return count; 

        return Math.min(count, countTop);

    }
}