from itertools import combinations

def check(n):
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return 0
    return 1

def solution(nums):
    answer = 0
    for c in combinations(nums, 3):
        if check(sum(c)):
            answer += 1
    return answer