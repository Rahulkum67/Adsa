class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        long x = val;
        if (st.isEmpty()) {
            st.push(x);
            min = x;
        } else {
            if (x < min) {
                // Store modified value
                st.push(2 * x - min);
                min = x;
            } else {
                st.push(x);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        long top = st.pop();
        if (top < min) {
            // Retrieve previous min
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = st.peek();
        if (top < min) {
            // Encoded value means real top is min
            return (int)min;
        }
        return (int)top;
    }

    public int getMin() {
        return (int)min;
    }
}
