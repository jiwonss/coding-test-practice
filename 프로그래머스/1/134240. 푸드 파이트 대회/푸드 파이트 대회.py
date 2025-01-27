def solution(food):
    temp = ''
    for i, v in enumerate(food[1:]):
        m = v // 2
        temp += str(i + 1) * m
    answer = temp + '0' + temp[::-1]
    return answer