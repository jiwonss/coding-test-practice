from collections import Counter

def solution(want, number, discount):
    product = {}
    for w, n in zip(want, number):
        product[w] = n
    
    answer = 0
    for i in range(len(discount) - 9):
        if product == Counter(discount[i:i + 10]):
            answer += 1
    return answer