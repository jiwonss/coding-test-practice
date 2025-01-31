def solution(wallet, bill):
    min_wallet, max_wallet = min(wallet), max(wallet)
    min_bill, max_bill = min(bill), max(bill)
    
    answer = 0
    while min_bill > min_wallet or max_bill > max_wallet:
        if bill[0] < bill[1]:
            bill[1] //= 2
        else:
            bill[0] //= 2
        min_bill, max_bill = min(bill), max(bill)
        answer += 1
    return answer