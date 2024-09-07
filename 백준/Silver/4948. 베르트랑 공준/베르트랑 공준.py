# 에라토스테네스의 체
def prime_list(n):
    sieve = [True] * n
    m = int(n ** 0.5)
    for i in range(2, m + 1):
        if sieve[i] == True:
            for j in range(i + i, n, i):
                sieve[j] = False

    return [i for i in range(2, n) if sieve[i] == True]

while 1:
    n = int(input())
    if n == 0: break
    li = prime_list(2 * n + 1)
    print(len([i for i in li if i > n]))
