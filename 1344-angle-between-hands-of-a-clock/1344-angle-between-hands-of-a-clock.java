class Solution {
    public double angleClock(int hour, int minutes) {
        double diff = Math.abs(30*hour - 5.5* minutes);
        double ans = Math.min(diff, 360-diff);
        return ans;
    }
}