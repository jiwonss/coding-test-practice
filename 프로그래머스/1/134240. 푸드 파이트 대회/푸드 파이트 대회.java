class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int m = (int) food[i] / 2;
            for (int j = 0; j < m; j++) {
                sb.append(String.valueOf(i));
            }
        }
        
        String answer = sb.toString() + "0" + sb.reverse().toString();
        return answer;
    }
}