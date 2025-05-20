from math import sqrt

def solution(k, d):
    answer = 0
    for x in range(0, d + 1, k):
        y_max = int(sqrt(d ** 2 - x ** 2))
        answer += y_max // k + 1
    return answer