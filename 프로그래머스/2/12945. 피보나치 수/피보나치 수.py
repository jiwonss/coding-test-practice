def solution(n):
    fibo = [0, 1, 1]
    for i in range(3, n + 1):
        fibo.append((fibo[i - 1] + fibo[i - 2]) % 1234567)
    return fibo[n]