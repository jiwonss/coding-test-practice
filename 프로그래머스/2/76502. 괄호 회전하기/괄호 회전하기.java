import java.util.*;

class Solution {
    public int solution(String s) {
        int x = s.length();
        int answer = 0;
        for (int i = 0; i < x; i++) {
            if (check(s.substring(i, x) + s.substring(0, i))) answer++;
        }
        return answer;
    }
    
    public boolean check(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) return false;
            if (ch == ')' && stack.peek() == '(') {
                stack.pop();
            }
            if (ch == ']' && stack.peek() == '[') {
                stack.pop();
            }
            if (ch == '}' && stack.peek() == '{') {
                stack.pop();
            }
        }
        return stack.isEmpty()? true : false; 
    }
}