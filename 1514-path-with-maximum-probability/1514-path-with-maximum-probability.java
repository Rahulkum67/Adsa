class Solution {
    class Pair{
        int node;
        double dist;
        Pair(int node,double dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            double wt=succProb[i];
            adj.get(from).add(new Pair(to,wt));
            adj.get(to).add(new Pair(from,wt));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Double.compare(b.dist ,a.dist));
        double[] temp=new double[n];
        temp[start_node]=1;
        pq.add(new Pair(start_node,1));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int cpn=curr.node;
            double prob=curr.dist;
            if(cpn == end_node){
                return prob;
            }
            for(int i=0;i<adj.get(cpn).size();i++){
                Pair nighbour=adj.get(cpn).get(i);
                int nighbournode=nighbour.node;
                double newprob=nighbour.dist;
                double pro=prob*newprob;
                if(pro > temp[nighbournode]){
                    temp[nighbournode]=pro;
                    pq.add(new Pair(nighbournode,pro));
                }
            }
        }
        return 0.0;
    }
}