class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                answer = mid;      // possible speed
                high = mid - 1;    // try smaller speed
            } else {
                low = mid + 1;     // need higher speed
            }
        }

        return answer;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil division
        }

        return hours <= h;
    }
}
