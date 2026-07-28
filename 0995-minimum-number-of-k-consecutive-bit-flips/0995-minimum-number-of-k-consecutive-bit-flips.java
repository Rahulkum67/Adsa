class Solution {
    public int minKBitFlips(int[] nums, int k) {
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0){
        //         count++;
        //     }
        // }
        
        // int ans=0;
        // for(int i=0;i<=nums.length-k;i++){
        //     if(nums[i]==0){
        //         ans++;
        //         for(int j=i;j<i+k;j++){
        //             if(nums[j]==0){
        //                 nums[j]=1;
        //                 count--;
        //             }else{
        //                 nums[j]=0;
        //                 count++;
        //             }
        //         }
        //     }
        // }
        // if(count==0){
        //     return ans;
        // }else{
        //     return -1;
        // }
        int n = nums.length;
        int ans = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (!q.isEmpty() && q.peek() == i) {
                q.poll();
            }

            if (q.size() % 2 == nums[i]) {

                if (i + k > n) {
                    return -1;
                }

                ans++;
                q.offer(i + k);
            }
        }
        return ans;
    }
}