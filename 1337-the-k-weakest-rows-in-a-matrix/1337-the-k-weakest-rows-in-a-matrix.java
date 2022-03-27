class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        var pq = new PriorityQueue<Row>((a,b)->{
                if(a.value!=b.value)
                    return a.value-b.value;
                else
                    return a.index-b.index;
            });
        
        var count=0;
        for(int i=0; i<mat.length; i++) {
            count=0;
            for(int j=0; j<mat[0].length;j++) {
                count+=mat[i][j];
            }
            pq.offer(new Row(count, i));
        }
        
        var ans=new int[k];
        
        count=0;
        while(count!=k) {
            ans[count++] = pq.poll().index;
        }
        
        return ans;
    }
    
    class Row {
        int value;
        int index;
        
        Row(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}