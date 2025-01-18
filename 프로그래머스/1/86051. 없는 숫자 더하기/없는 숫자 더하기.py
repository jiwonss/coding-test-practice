def solution(numbers):
    answer = 45
    for n in numbers:
        answer -= n
    return answer