

class Solution {
    
    List<String> result = new ArrayList<>();
    
    public List<String> readBinaryWatch(int turnedOn) {
        backtrack(turnedOn, 0, 0, 0);
        return result;
    }
    
    // remaining LEDs, current index, current hour, current minute
    private void backtrack(int leds, int index, int hour, int minute) {
        
        // If hour or minute invalid → stop
        if (hour > 11 || minute > 59) return;
        
        // If no LEDs left to turn on
        if (leds == 0) {
            result.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
            return;
        }
        
        // Try turning on remaining LEDs
        for (int i = index; i < 10; i++) {
            
            if (i < 4) {
                // Hour LEDs (0–3)
                backtrack(leds - 1, i + 1, hour + (1 << i), minute);
            } else {
                // Minute LEDs (4–9)
                backtrack(leds - 1, i + 1, hour, minute + (1 << (i - 4)));
            }
        }
    }
}
