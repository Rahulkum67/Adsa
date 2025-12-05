class Solution {
    public int majorityElement(int[] nums) {
        
        /*HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(int key:map.keySet()){
            if(map.get(key)>n/2);
            return key;
        }
        return -1; */
        int n=nums.length;
        int count=0;
        int element=0;
        for(int i=0;i<n;i++){
            if(count == 0){
                count=1;
                element=nums[i];
            }else if(element==nums[i]) count++;
            else count--;
            
        }
        int count1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==element) count1++;
        }
        if(count1>n/2) return element;
        return -1;
    }
}