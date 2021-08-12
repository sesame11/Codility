import java.util.Stack;

public class Nesting {
    public int solution(String S) {
        if (S.isEmpty()) return 1;
        if (S.charAt(0) == ')') return 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') stack.push(c);
            else if (stack.isEmpty()) {
                return 0;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
