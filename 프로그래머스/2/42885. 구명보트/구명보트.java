import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0;
        int start = 0; int end = people.length - 1;
        while (start <= end) {
            answer++;
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
        }
        return answer;
    }
}