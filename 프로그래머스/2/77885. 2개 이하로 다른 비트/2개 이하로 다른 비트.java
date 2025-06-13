class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            answer[i] = ((n ^ (n + 1)) >> 2) + n + 1;
        }
        return answer;
    }
}