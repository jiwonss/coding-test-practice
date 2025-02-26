from collections import Counter

def solution(k, tangerine):
    counter = Counter(tangerine)
    
    answer = 0
    for key, value in sorted(counter.items(), key=lambda x : -x[1]):
        answer += 1
        k -= value
        if k <= 0:
            break
    return answer