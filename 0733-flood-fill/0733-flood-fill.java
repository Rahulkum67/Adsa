// class Solution {
//     class Pair{
//         int row;
//         int col;
//         Pair(int row,int col){
//             this.row=row;
//             this.col=col;
//         }
//     }
//     int[] rowdirection={1,-1,0,0};
//     int[] coldirection={0,0,1,-1};
//     public boolean isvalid(int x,int y,int n,int m){
//         return (x>=0 && x<n && y>=0 && y<m);
//     }
    
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int originalColor = image[sr][sc];

//         Queue<Pair> q=new LinkedList<>();
//         int n=image.length;
//         int m=image[0].length;
//         boolean[][] isvisted=new boolean[n][m];
//         q.add(new Pair(sr,sc));
//         isvisted[sr][sc]=true;
//         while(!q.isEmpty()){
//             Pair curr=q.poll();
//             int currpairrow=curr.row;
//             int currpaircol=curr.col;
//             image[currpairrow][currpaircol]=color;
//             for(int i=0;i<4;i++){
//                 int nerow=currpairrow + rowdirection[i];
//                 int necol=currpaircol + coldirection[i];
//                 if(isvalid(nerow,necol,n,m) && image[nerow][necol]==originalColor&&isvisted[nerow][necol]==false){
//                     isvisted[nerow][necol]=true;
//                     q.add( new Pair(nerow,necol));
//                 }
//             }
//         }
//         return image;
//     }
// }
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
     int originalColor = image[sr][sc];
     if(originalColor == color)return image;

     dfs(image , sr, sc, originalColor, color);
     return image;   
    }
    private void dfs(int[][] image, int r, int c, int originalColor, int newColor){
        if (r < 0 || c< 0|| r>=image.length || c >=image[0].length
            || image[r][c] != originalColor){
            return;

            }

         image[r][c] = newColor;

         dfs(image, r+1, c, originalColor, newColor);
         dfs(image, r-1, c, originalColor, newColor);
         dfs(image, r, c+1, originalColor, newColor);
         dfs(image, r, c-1, originalColor, newColor);
    }
}