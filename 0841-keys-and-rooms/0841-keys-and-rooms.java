class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q=new LinkedList<>();
        boolean[] isvist=new boolean[rooms.size()];
        q.add(0);
        isvist[0]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<rooms.get(curr).size();i++){
                int nighbour=rooms.get(curr).get(i);
                if(isvist[nighbour]==false){
                    isvist[nighbour]=true;
                    q.add(nighbour);
                }
            }
        }
        for(boolean b:isvist){
            if(b==false){
                return false;
            }
        }
        return true;
    }
}