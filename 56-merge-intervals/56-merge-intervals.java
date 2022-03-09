class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int current = 0;
        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{intervals[0][0], intervals[0][1]});
        
        for(int i=1; i<intervals.length; i++) {
            if(ans.get(current)[1] >= intervals[i][0]) {
                ans.get(current)[1] = Math.max(ans.get(current)[1],intervals[i][1]);
            } else {
                ans.add(intervals[i]);
                current++;
            }
        }
        int[][] res = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}