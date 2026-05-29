class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        Map<Integer , List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],k-> new ArrayList<>()).add(i);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] isv=new boolean[n];
        q.add(0);
        isv[0]=true;
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                if(curr==n-1) return step;

                if(curr-1 >= 0 && isv[curr-1]==false){
                    isv[curr-1]=true;
                    q.add(curr-1);
                }

                if(curr+1 < n && isv[curr+1]==false){
                    isv[curr+1]=true;
                    q.add(curr+1);
                }
                if(map.containsKey(arr[curr])){
                    for(int next:map.get(arr[curr])){
                        if(!isv[next]){
                            isv[next]=true;
                            q.add(next);
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            step++;
        }
        return -1;
    }
}