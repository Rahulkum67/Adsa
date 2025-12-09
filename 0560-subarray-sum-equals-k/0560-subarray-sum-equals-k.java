class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // To handle subarrays starting from index 0
        map.put(0, 1);

        int sum = 0;
        int count = 0;

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