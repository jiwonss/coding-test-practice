class Solution {

    static int len, answer;
    static int[] num, arr;
    static boolean[] visited;
    
    public int solution(int[] number) {
        num = number; len = number.length;
        arr = new int[3]; visited = new boolean[len];
        
        combination(0, 0);
        
        return answer;
    }
    
    public void combination(int k, int start) {
        if (k == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += arr[i];
            }
            if (sum == 0) {
                answer += 1;
            }
            return;
        }
        
        for (int i = start; i < len; i++) {
            if (visited[i]) continue;
            arr[k] = num[i];
            visited[i] = true;
            combination(k + 1, i);
            visited[i] = false;
        }
    }
    
    
}