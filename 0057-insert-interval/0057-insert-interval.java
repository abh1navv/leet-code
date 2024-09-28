class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean isAdded = false;
        for(int[] interval: intervals) {
            if(interval[1] < newInterval[0]) {
                list.add(interval);
            } else {
                if(interval[0] > newInterval[1] && isAdded) {
                    list.add(interval);
                } else if(interval[0] > newInterval[1]) {
                    list.add(newInterval);
                    list.add(interval);
                    isAdded = true;
                } else {
                    //merge and don't add
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(interval[1], newInterval[1]);
                }
            }
        }   
        
        if(!isAdded) {
            list.add(newInterval);
        }
        
        int[][] array = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
        
        return array;
    }
}