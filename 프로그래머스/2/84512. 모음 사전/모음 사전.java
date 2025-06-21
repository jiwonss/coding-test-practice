class Solution {
    public int solution(String word) {
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            answer += "AEIOU".indexOf(w) * ((Math.pow(5, 5 - i) - 1) / 4) + 1;
        }
        return answer;
    }
}