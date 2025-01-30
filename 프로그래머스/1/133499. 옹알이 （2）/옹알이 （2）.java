class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};
        for (String b : babbling) {
            for (String w : word) {
                if (!b.contains(w + w)) {
                    b = b.replace(w, " ");
                }
            }
            if (b.strip().length() == 0) {
                answer += 1;
            }
        }
        return answer;
    }
}