from sys import stdin
from collections import Counter
input = stdin.readline


def solve():
    N = int(input())
    card = Counter(list(map(int, input().split())))
    M = int(input())
    num = list(map(int, input().split()))

    for n in num:
        print(card[n], end=' ')


if __name__ == "__main__":
    solve()
