from sys import stdin
from itertools import combinations

input = stdin.readline


def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


def solve():
    t = int(input())
    for _ in range(t):
        temp = list(map(int, input().split()))
        n, arr = temp[0], temp[1:]

        result = 0
        for a, b in combinations(arr, 2):
            result += gcd(a, b)
        print(result)


if __name__ == "__main__":
    solve()
