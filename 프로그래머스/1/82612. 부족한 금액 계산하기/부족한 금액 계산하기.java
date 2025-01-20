class Solution {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;
        for (int i = 0; i < count; i++) {
            totalPrice += price * (i + 1);
        }
        
        long answer = money - totalPrice;
        return (answer < 0)? Math.abs(answer) : 0;
    }
}