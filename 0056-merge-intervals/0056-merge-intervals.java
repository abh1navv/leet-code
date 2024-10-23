class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> intervalList = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);        
        int[] curr=null;
        for(int[] interval: intervals) {
            if(curr == null || interval[0]>curr[1]) {
                intervalList.add(curr);
                curr = interval;
            } else {
                curr[1] = Math.max(interval[1], curr[1]);
            }
        }
        intervalList.add(curr);
        intervalList.remove(0);
        
        
        int[][] arr = new int[intervalList.size()][2];
        for(int i=0; i<intervalList.size(); i++) {
            arr[i] = intervalList.get(i);
        }
        
        return arr;
    }
}