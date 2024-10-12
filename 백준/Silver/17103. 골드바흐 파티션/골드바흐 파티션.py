from sys import stdin

input = stdin.readline


def get_prime_number_list(n):
    sieve = [1] * (n + 1)
    sieve[0] = sieve[1] = 0

    for i in range(2, int(n**0.5) + 1):
        if sieve[i]:
            for j in range(i * i, n + 1, i):
                sieve[j] = 0
    return [i for i in range(n + 1) if sieve[i]]


def solve():
    prime_number_list = get_prime_number_list(1000000)
    prime_number_set = set(prime_number_list)

    T = int(input())
    for _ in range(T):
        N = int(input())

        result = 0
        for p in prime_number_list:
            if p > N // 2:
                break
            if (N - p) in prime_number_set:
                result += 1
        print(result)


if __name__ == "__main__":
    solve()
