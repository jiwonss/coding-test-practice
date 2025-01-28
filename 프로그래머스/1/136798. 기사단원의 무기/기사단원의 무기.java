class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int n = 1; n < number + 1; n++) {
            int count = getDivisorCount(n);
            if (count <= limit) {
                answer += count;
            } else {
                answer += power;
            }
        }
        return answer;
    }
    
    public int getDivisorCount(int n) {
        int count = 0;
        for (int i = 1; i < (int) Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                count += 1;
                if (i * i != n) {
                    count += 1;
                }
            }
        }
        return count;
    }
}