class Solution {
    
    int n, answer;
    int[][] dungeons;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length; this.dungeons = dungeons;
        
        visited = new boolean[n];
        answer = 0;
        adventure(0, k);
        return answer;
    }
    
    public void adventure(int cnt, int k) {
        answer = Math.max(answer, cnt);
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || k < dungeons[i][0]) continue;
            visited[i] = true;
            adventure(cnt + 1, k - dungeons[i][1]);
            visited[i] = false;
        }
    }
}