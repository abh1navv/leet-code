class Solution {
    public int equalPairs(int[][] grid) {
        Map<Integer, String> rowMap = new HashMap<>();
        Map<Integer, String> colMap = new HashMap<>();

        
    
        for(int i=0;i<grid.length;i++) {
            StringBuilder sb=new StringBuilder();
            for(int j=0; j<grid[0].length;j++) {
                sb.append(grid[i][j]).append(" ");
            }
            rowMap.put(i, sb.toString());
        }
        
        for(int i=0;i<grid[0].length;i++) {
            StringBuilder sb=new StringBuilder();
            for(int j=0; j<grid.length;j++) {
                sb.append(grid[j][i]).append(" ");
            }
            colMap.put(i, sb.toString());
        }
        
        int count=0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0; j<grid[0].length;j++) {
                if(rowMap.get(i).equals(colMap.get(j))) count++;
            }
        }
        
        return count;
    }
}