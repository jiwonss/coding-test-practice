def solution(price, money, count):
    total_price = 0
    for i in range(count):
        total_price += price * (i + 1)
        
    answer = money - total_price
    return abs(answer) if answer < 0 else 0