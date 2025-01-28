class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx = 0;
        int cards1Idx = 0; int cards2Idx = 0;
        while (idx < goal.length) {
            if (cards1Idx < cards1.length && cards1[cards1Idx].equals(goal[idx])) {
                cards1Idx += 1;
                idx += 1;
            }
            else if (cards2Idx < cards2.length && cards2[cards2Idx].equals(goal[idx])) {
                cards2Idx += 1;
                idx += 1;
            } else {
                break;
            }
        }
        return (idx == goal.length) ? "Yes" : "No";
    }
}