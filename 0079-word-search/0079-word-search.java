class Solution {
    int[] rd={-1,1,0,0};
    int[] cd={0,0,-1,1};
    boolean dfs(char[][] board,String word,int cr,int cc,int index){
        if(index == word.length()){
            return true;
        }
        if(cr < 0 || cc < 0 || cr >= board.length || cc>=board[0].length || board[cr][cc] !=word.charAt(index)){
            return false;
        }
        char temp = board[cr][cc];
        board[cr][cc]='#';
        for(int i=0;i<4;i++){
            int nr=cr+rd[i];
            int nc=cc+cd[i];
            if(dfs(board,word,nr,nc,index+1)){
                return true;
            }
        }
        board[cr][cc]=temp;
        return false;

        
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}