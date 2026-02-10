class Solution {
    public void bfs(int start,boolean isvist[],ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        isvist[start]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<adj.get(curr).size();i++){
                int nighbour=adj.get(curr).get(i);
                if(isvist[nighbour]==false){
                    isvist[nighbour]= true;
                    q.add(nighbour);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                int from=i;
                int to = j;
                adj.get(from).add(to);
                }
                
            }
        }
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        boolean isvist[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(isvist[i]==false){
                bfs(i,isvist,adj);
                count++;
            }
            
            
        }
        return count;
    }
}