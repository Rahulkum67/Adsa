class Solution {
    public boolean containsNearbyAlmostDuplicate(
            int[] nums, int indexDiff, int valueDiff) {

        if (indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        Map<Long, Long> buckets = new HashMap<>();

        long size = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {

            long x = nums[i];

            // Find bucket
            long bucketId = getBucket(x, size);

            // Same bucket
            if (buckets.containsKey(bucketId)) {
                return true;
            }

            // Previous bucket
            if (buckets.containsKey(bucketId - 1)
                    && Math.abs(x - buckets.get(bucketId - 1)) <= valueDiff) {
                return true;
            }

            // Next bucket
            if (buckets.containsKey(bucketId + 1)
                    && Math.abs(x - buckets.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            // Put current value
            buckets.put(bucketId, x);

            // Remove element outside sliding window
            if (i >= indexDiff) {
                long old = nums[i - indexDiff];
                long oldBucket = getBucket(old, size);

                buckets.remove(oldBucket);
            }
        }

        return false;
    }

    private long getBucket(long x, long size) {

        if (x >= 0) {
            return x / size;
        }

        return ((x + 1) / size) - 1;
    }
}