class Solution {
    public String solution(String s) {
        boolean check = true;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer.append(c);
                check = true;
            } else if (check) {
                answer.append(Character.toUpperCase(c));
                check = false;
            } else {
                answer.append(Character.toLowerCase(c));
            }
        }
        return answer.toString();
    }
}