from sys import stdin
from math import sqrt

input = stdin.readline


def get_prime_number_list(n):
    m = int(n**0.5)

    sieve = [1] * (m + 1)
    sieve[0] = sieve[1] = 0

    for i in range(2, m + 1):
        if sieve[i]:
            for j in range(i * i, m + 1, i):
                sieve[j] = 0
    return [i for i in range(m + 1) if sieve[i]]


def solve():
    A, B = map(int, input().split())

    prime_numbers = get_prime_number_list(B)

    result = 0
    for n in prime_numbers:
        power = n * n
        while power <= B:
            if power >= A:
                result += 1
            power *= n
    print(result)


if __name__ == "__main__":
    solve()
