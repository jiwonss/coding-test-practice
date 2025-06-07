from collections import Counter

def solution(weights):
    counter = Counter(weights)
    answer = 0
    for k, v in counter.items():
        answer += v * (v - 1) // 2
        for a, b in [(2, 3), (2, 4), (3, 4)]:
            answer += counter[k * (a / b)] * v
    return answer