from itertools import combinations

def solution(numbers):
    answer = set()
    for c in combinations(numbers, 2):
        answer.add(c[0] + c[1])
    return sorted(list(answer))