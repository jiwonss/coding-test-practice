class Solution {
    public int solution(int[] wallet, int[] bill) {
        int minWallet, maxWallet, minBill, maxBill;
        minWallet = Math.min(wallet[0], wallet[1]); maxWallet = Math.max(wallet[0], wallet[1]);
        minBill = Math.min(bill[0], bill[1]); maxBill = Math.max(bill[0], bill[1]);
        
        int answer = 0;
        while (minBill > minWallet || maxBill > maxWallet) {
            if (bill[0] < bill[1]) {
                bill[1] = (int) bill[1] / 2;
            } else {
                bill[0] = (int) bill[0] / 2;
            }
            minBill = Math.min(bill[0], bill[1]); maxBill = Math.max(bill[0], bill[1]);
            answer += 1;
        }
        return answer;
    }
}