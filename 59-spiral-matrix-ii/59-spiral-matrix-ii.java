class Solution {
    public int[][] generateMatrix(int n) {
        int[][] grid=new int[n][n];
        int rowStart=0, colStart=0, rowEnd=n-1, colEnd=n-1, next=1;
        
        while(rowStart <= rowEnd && colStart<= colEnd) {
            //traverse right
            for(int i=colStart; i<=colEnd; i++) {
                grid[rowStart][i] = next++;
            }
            rowStart++;
            //traverse down
            for(int i=rowStart; i<=rowEnd; i++) {
                grid[i][colEnd] = next++;
            }
            colEnd--;
            //traverse left
            if(rowStart<=rowEnd) {
                for(int i=colEnd; i>=colStart; i--) {
                    grid[rowEnd][i] = next++;
                }
                rowEnd--;
            }
            //traverse up
            if(colStart<=colEnd) {
                for(int i=rowEnd; i>=rowStart; i--) {
                    grid[i][colStart] = next++;
                }
                colStart++;
            }
        }
        
        return grid;
    }
}