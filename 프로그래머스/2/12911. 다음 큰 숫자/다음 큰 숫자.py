def solution(n):
    cnt = bin(n).count("1")
    for x in range(n + 1, 1000001):
        if bin(x).count("1") == cnt:
            return x
    return -1