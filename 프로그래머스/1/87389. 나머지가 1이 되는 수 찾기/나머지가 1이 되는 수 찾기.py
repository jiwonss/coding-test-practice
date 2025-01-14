def solution(n):
    x = 1
    while x < n:
        if n % x == 1:
            return x
        x += 1   