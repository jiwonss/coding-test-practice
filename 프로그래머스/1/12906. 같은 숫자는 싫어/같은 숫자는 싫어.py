def solution(arr):
    answer = []
    for a in arr:
        while answer and a == answer[-1]:
            answer.pop()
        answer.append(a)
    return answer