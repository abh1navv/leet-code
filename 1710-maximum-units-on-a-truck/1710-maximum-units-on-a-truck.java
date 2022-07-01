class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (first, second) -> -first[1]+second[1]);
        int count=0, curr;
        for(int i=0; i<boxTypes.length; i++) {
            if(truckSize>0) {
                curr= Math.min(boxTypes[i][0], truckSize);
                truckSize-= curr;
                count+=boxTypes[i][1]*curr;
            } 
        }
        return count;
    }
}