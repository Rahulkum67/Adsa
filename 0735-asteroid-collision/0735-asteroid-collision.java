import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (st.isEmpty()) {
                st.push(asteroids[i]);
            } else {
                if (st.peek() > 0 && asteroids[i] > 0) {
                    st.push(asteroids[i]);
                } else if (st.peek() < 0 && asteroids[i] < 0) {
                    st.push(asteroids[i]);
                } else if (st.peek() > 0 && asteroids[i] < 0) { // corrected direction
                    if (Math.abs(st.peek()) > Math.abs(asteroids[i])) {
                        continue;
                    } else if (Math.abs(st.peek()) < Math.abs(asteroids[i])) {
                        st.pop();
                        i--; // recheck current asteroid with new top
                    } else {
                        st.pop(); // both explode
                    }
                } else {
                    st.push(asteroids[i]);
                }
            }
        }

        int[] arr = new int[st.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }
        return arr;
    }
}
