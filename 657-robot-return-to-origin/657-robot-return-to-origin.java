class Solution {
    public boolean judgeCircle(String moves) {
        int row=0,col=0;
        for(char ch: moves.toCharArray()) {
            switch(ch) {
                case 'U':
                    row--;
                    break;
                case 'D':
                    row++;
                    break;
                case 'L':
                    col--;
                    break;
                case 'R':
                    col++;
                    break;
            }
        }
        
        return row==0 && col==0;
    }
}