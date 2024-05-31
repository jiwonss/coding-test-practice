from sys import stdin
from math import ceil
input = stdin.readline


def solve():
    num = [0] * 10

    N = input().strip()

    for n in N:
        num[int(n)] += 1

    result = 0
    for i in range(10):
        if i == 6 or i == 9:
            continue
        result = max(result, num[i])
    result = max(result, ceil((num[6] + num[9]) / 2))
    print(result)


if __name__ == "__main__":
    solve()
