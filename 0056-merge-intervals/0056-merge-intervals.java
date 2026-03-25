class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr , (a,b) -> a[0]- b[0]);
        List<int[]> ans=new ArrayList<>();
        for(int[] ar:arr){
            if(ans.isEmpty()|| ans.get(ans.size() - 1)[1]<ar[0]){
                ans.add(ar);
            }else{
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1] ,ar[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}