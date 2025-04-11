class Solution {
    
    int n, target, answer;
    int[] numbers;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        this.target = target; this.numbers = numbers;
        
        answer = 0;
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int k, int total) {
        if (k == n) {
            if (total == target) {
                answer++;
            }
            return;
        }
        dfs(k + 1, total + numbers[k]);
        dfs(k + 1, total - numbers[k]);
    }
}