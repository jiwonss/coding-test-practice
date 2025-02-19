class Solution {
    public String solution(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' || Character.isDigit(c)) {
                answer += c;
                continue;
            }
            if (i == 0 || (i > 0 && s.charAt(i - 1) == ' ')) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
        }
        return answer;
    }
}