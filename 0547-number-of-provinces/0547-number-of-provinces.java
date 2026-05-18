class Solution {
    void bfs(int st,boolean[] isvis,ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q=new LinkedList<>();
        q.add(st);
        isvis[st]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<adj.get(curr).size();i++){
                int nighbour=adj.get(curr).get(i);
                if(isvis[nighbour]==false){
                    isvis[nighbour]=true;
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
                    adj.get(i).add(j);
                }
            }
        }
        int count=0;
        boolean[] isvis=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(isvis[i]==false){
                bfs(i,isvis,adj);
                count++;
            }
        }
        return count;
    }
}