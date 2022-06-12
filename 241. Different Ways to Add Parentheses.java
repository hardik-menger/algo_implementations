import java.util.*;

class L241 {
    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '*' || ch == '-') {
                String leftExpression = expression.substring(0, i);
                String rightExpression = expression.substring(i + 1);
                List<Integer> left = map.getOrDefault(leftExpression, diffWaysToCompute(leftExpression));
                List<Integer> right = map.getOrDefault(rightExpression, diffWaysToCompute(rightExpression));
                for (int leftAns : left) {
                    for (int rightAns : right) {
                        int res = 0;
                        switch (ch) {
                            case '*':
                                res = leftAns * rightAns;
                                break;
                            case '+':
                                res = leftAns + rightAns;
                                break;
                            case '-':
                                res = leftAns - rightAns;
                                break;
                        }
                        result.add(res);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(expression));
        }
        map.put(expression, result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        L241 obj = new L241();
    }
}
