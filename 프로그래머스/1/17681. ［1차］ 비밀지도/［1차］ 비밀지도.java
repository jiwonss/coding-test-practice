class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String password = Integer.toBinaryString(arr1[i] | arr2[i]);
            String result = String.format("%" + n + "s", password).replace(" ", "0");
            answer[idx++] = result.replace("0", " ").replace("1", "#");
        }
        return answer;
    }
}