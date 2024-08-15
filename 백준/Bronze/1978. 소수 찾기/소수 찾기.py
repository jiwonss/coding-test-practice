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
    N = int(input())
    arr = list(map(int, input().split()))

    result = 0
    for i in range(N):
        if is_prime_number(arr[i]):
            result += 1
    print(result)


if __name__ == "__main__":
    solve()
