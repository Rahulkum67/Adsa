class Solution {
    class Pair{
        int node ,cost;
        Pair(int node,int cost){
            this.node=node;
            
            this.cost=cost;
        }
    }
    class Tuple{
        int node , cost , stops;
        Tuple(int node, int cost,int stops){
            this.node=node;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            int from=flights[i][0];
            int to=flights[i][1];
            int wt=flights[i][2];
            adj.get(from).add(new Pair(to,wt));
        }
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(src,0,0));
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            Tuple curr=q.poll();
            int ctn=curr.node;
            int ctc=curr.cost;
            int cts=curr.stops;
            if(cts > k) continue;
            for(int i=0;i<adj.get(ctn).size();i++){
                Pair nighbour=adj.get(ctn).get(i);
                int newnode=nighbour.node;
                int newcost=nighbour.cost;
                if(ctc + newcost < dist[newnode]){
                    dist[newnode]=ctc+newcost;
                    q.add(new Tuple(newnode,dist[newnode],cts+1));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];

    }
}