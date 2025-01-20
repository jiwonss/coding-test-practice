def get_divisor_count(k):
    cnt = 0
    for n in range(1, k + 1):
        if k % n == 0:
            cnt += 1
    return cnt

def solution(left, right):
    answer = 0
    for n in range(left, right + 1):
        if get_divisor_count(n) % 2 == 0:
            answer += n
        else:
            answer -= n
    return answer