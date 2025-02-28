import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int a : arr) {
            dq.push(a);
        }
        
        while (dq.size() != 1) {
            int size = dq.size();
            for (int i = 0; i < size - 1; i++) {
                int a = dq.pop();
                int b = dq.pop();
                dq.push(lcm(a, b));
            }
        }
        return dq.peek();
    }
    
    public int gcd(int a, int b) {
        int temp = 0;
        while (b > 0) {
            temp = a;
            a = b; b = temp % b;
        }
        return a;
    }
    
    public int lcm(int a, int b) {
        return (int) (a * b) / gcd(a, b);
    }
}