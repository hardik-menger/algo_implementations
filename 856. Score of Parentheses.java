import java.util.*;

class L856 {

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int curr = stack.pop();
                int prev = stack.pop();
                stack.push(prev + Math.max(curr * 2, 1));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) throws Exception {
        L856 obj = new L856();
    }
}
