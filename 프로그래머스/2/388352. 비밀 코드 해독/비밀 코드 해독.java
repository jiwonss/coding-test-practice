import java.util.*;

class Solution {
    
    int _n, m, answer;
    int[] num, code, response;
    boolean[] visited;
    List<Set<Integer>> inputList;
    
    public int solution(int n, int[][] q, int[] ans) {
        _n = n; m = q.length; response = ans;
        
        inputList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                list.add(q[i][j]);
            }
            inputList.add(new HashSet<>(list));
        }
        
        num = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            num[i] = i;
        }
        
        answer = 0;
        code = new int[5];
        combination(0, 1);
        return answer;
    }
    
    public void combination(int k, int start) {
        if (k == 5) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 5; i++) {
                set.add(code[i]);
            }
            if (compare(set)) answer++;
            return;
        }
        
        for (int i = start; i < _n + 1; i++) {
            if (visited[i]) continue;
            code[k] = i;
            visited[i] = true;
            combination(k + 1, i + 1);
            visited[i] = false;
        }
    }
    
    public boolean compare(Set<Integer> set) {
        Set<Integer> temp = new HashSet<>(set);
        for (int i = 0; i < m; i++) {
            temp.retainAll(inputList.get(i));
            if (temp.size() != response[i]) {
                return false;
            }
            temp = new HashSet<>(set);
        }
        return true;
    }
}