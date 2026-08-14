class Solution {
    public int totalFruit(int[] fruits) {
        int maxcount=0;
        int i=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int j=0;j<fruits.length;j++){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            
            while(map.size()>2){
                map.put(fruits[i],map.get(fruits[i])-1);
                
                if(map.get(fruits[i])==0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            count=Math.max(count,j-i+1);
        }
        return count;
    }
}