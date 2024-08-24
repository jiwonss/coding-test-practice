from sys import stdin
from math import sqrt
input = stdin.readline


def get_prime_number_list(n):
    arr = [1] * (n + 1)
    arr[0] = arr[1] = 0
    for i in range(2, int(sqrt(n)) + 1):
        if arr[i]:
            j = 2
            while i * j <= n:
                arr[i * j] = 0
                j += 1
    return [i for i in range(2, n + 1) if arr[i]]


def solve():
    N = int(input())

    num = [0] + get_prime_number_list(N)
    for i in range(1, len(num)):
        num[i] += num[i - 1]

    left, right, result = 0, 0, 0
    while right < len(num):
        total = num[right] - num[left]
        if total == N:
            result += 1
        if total < N:
            right += 1
        else:
            left += 1
    print(result)


if __name__ == "__main__":
    solve()
