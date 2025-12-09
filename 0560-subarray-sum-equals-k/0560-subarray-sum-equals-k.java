class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        //Better solution
        /*for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k){
                count++;
                }
            }
            
        }*/
        //Optimal solution
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // To handle subarrays starting from index 0
        map.put(0, 1);

        int sum = 0;
        

        for (int num : nums) {
            sum += num;

            // Check if (sum - k) exists
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Update prefix sum frequency
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}