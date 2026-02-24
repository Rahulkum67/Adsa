class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.dist - b.dist);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int from=times[i][0]-1;
            int to=times[i][1]-1;
            int weight=times[i][2];
            adj.get(from).add(new Pair(to,weight));
            
        }
        pq.add(new Pair(k-1,0));
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k-1]=0;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int cpv=curr.node;
            int cpd=curr.node;
            for(int i=0;i<adj.get(cpv).size();i++){
                Pair nighbour=adj.get(cpv).get(i);
                int nv=nighbour.node;
                int nd=nighbour.dist;
                if(ans[cpv]+ nd < ans[nv]){
                    ans[nv]=ans[cpv]+nd;
                    pq.add(new Pair(nv,ans[nv]));
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(ans[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,ans[i]);

        }
        return max;
    }
}