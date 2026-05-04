import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size() >1){
            int first=pq.poll();
            int second=pq.poll();
            if(first != second){
                pq.add(first-second);
            }
        }
        if(pq.size()==0) return 0;
        return pq.poll();
    }
}
