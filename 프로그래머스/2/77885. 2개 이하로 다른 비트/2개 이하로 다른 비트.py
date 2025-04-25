def solution(numbers):
    return [((n ^ (n + 1)) >> 2) + n + 1 for n in numbers]