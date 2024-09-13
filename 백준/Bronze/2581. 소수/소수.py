from sys import stdin

input = stdin.readline


def is_prime_number(n):
    if n < 2:
        return 0
    i = 2
    while i * i <= n:
        if n % i == 0:
            return 0
        i += 1
    return 1


def solve():
    M = int(input())
    N = int(input())

    result = []
    for i in range(M, N + 1):
        if is_prime_number(i):
            result.append(i)

    if result:
        print(sum(result))
        print(min(result))
    else:
        print(-1)


if __name__ == "__main__":
    solve()
