def solution(a, b):
    min_value, max_value = min(a, b), max(a, b)
    answer = 0
    for i in range(min_value, max_value + 1):
        answer += i
    return answer