class Solution {
    public boolean isBipartite(int[][] edges) {
        int V=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        Queue<Integer> q=new LinkedList<>();
        char[] iscolor=new char[V];
        q.add(0);
        iscolor[0]='r';
        boolean[] isvisted=new boolean[V];
        isvisted[0]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<adj.get(curr).size();i++){
                int nighbour=adj.get(curr).get(i);
                if(isvisted[nighbour]==false){
                    isvisted[nighbour]=true;
                    if(iscolor[curr]=='r'){
                    iscolor[nighbour]='b';
                    }else{
                    iscolor[nighbour]='r';
                    }
                    q.add(nighbour);
                }
                else {
                    if(iscolor[curr]==iscolor[nighbour]) return false;
                }
                

            }

        }
        return true;
    }
}