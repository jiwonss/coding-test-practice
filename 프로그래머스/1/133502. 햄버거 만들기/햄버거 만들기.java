import java.util.*;

class Solution {
    
    Stack<Integer> stack = new Stack<>();
    
    public int solution(int[] ingredient) {
        int answer = 0;
        for (int i : ingredient) {
            stack.add(i);
            int size = stack.size();
            if (size > 3 && check(size - 1)) {
                for (int k = 0; k < 4; k++) {
                    stack.pop();
                }
                answer++;
            }
        }
        return answer;
    }
    
    public boolean check(int idx) {
        if (stack.get(idx) != 1 || stack.get(idx - 3) != 1) return false;
        if (stack.get(idx - 1) != 3) return false;
        if (stack.get(idx - 2) != 2) return false;
        return true;
    }
}