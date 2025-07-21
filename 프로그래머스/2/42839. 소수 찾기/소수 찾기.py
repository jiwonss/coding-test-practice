from itertools import permutations 

def is_prime(n):
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return 0
    return 1

def solution(numbers):
    n = len(numbers)
    answer = set()
    for i in range(1, n + 1):
        for p in permutations(numbers, i):
            answer.add(int(''.join(p)))
    return len([a for a in answer if a > 1 and is_prime(a)])