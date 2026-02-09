class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean ans=false;
        boolean[] isvit=new boolean[n];
        q.add(source);
        isvit[source]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            if (curr == destination) return true;
            for(int nighbour : adj.get(curr)){
                
                if(isvit[nighbour]==false){
                    isvit[nighbour]=true;
                    q.add(nighbour);
                    
                }
            }
        }
        return ans;
    }
}