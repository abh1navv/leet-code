class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> row=new ArrayList<>();
        List<Set<Character>> col=new ArrayList<>();
        List<Set<Character>> block=new ArrayList<>();
        
        for(int i=0;i<9;i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            block.add(new HashSet<>());
        }
        
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                char value = board[i][j];
                if(value=='.') {
                    continue;
                }
                
                if(row.get(i).contains(value)) {
                
                    return false;
                }
                else row.get(i).add(value);
                
                if(col.get(j).contains(value)) {
                   
                    return false;
                }
                else col.get(j).add(value);
                
                int blockNumber = i/3 * 3 + j/3;
                if(block.get(blockNumber).contains(value)) {
                   
                    return false;
                }
                else block.get(blockNumber).add(value);
            }
        }
        
        return true;
    }
    
}