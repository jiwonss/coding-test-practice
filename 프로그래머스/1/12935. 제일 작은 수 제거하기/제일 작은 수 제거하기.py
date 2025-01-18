def solution(arr):
    min_value, answer = min(arr), []
    for a in arr:
        if a != min_value:
            answer.append(a)
    return answer if answer else [-1]