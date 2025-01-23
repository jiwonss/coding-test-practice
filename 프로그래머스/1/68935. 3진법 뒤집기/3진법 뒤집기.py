def solution(n):
    result = []
    while n != 0:
        result.append(n % 3)
        n //= 3
    
    answer = 0
    result.reverse()
    for i in range(len(result)):
        answer += (3 ** i) * result[i]
    return answer