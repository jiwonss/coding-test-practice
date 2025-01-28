def get_divisor_count(n):
    cnt = 0
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            cnt += 1
            if i * i != n:
                cnt += 1
    return cnt
            

def solution(number, limit, power):
    answer = 0
    for n in range(1, number + 1):
        cnt = get_divisor_count(n)
        if cnt <= limit:
            answer += cnt
        else:
            answer += power
    return answer