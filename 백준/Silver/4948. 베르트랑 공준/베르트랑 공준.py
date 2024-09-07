from sys import stdin
input = stdin.readline


def count_prime_number(a, b):
    sieve = [1] * (b + 1)
    sieve[0] = sieve[1] = 0

    for i in range(2, int(b ** 0.5) + 1):
        for j in range(i, b, i):
            if sieve[j]:
                sieve[j] = 0
    return sieve[a:b].count(1)


def solve():
    while True:
        n = int(input())

        if n == 0:
            return

        print(count_prime_number(n + 1, 2 * n + 1))


if __name__ == "__main__":
    solve()
