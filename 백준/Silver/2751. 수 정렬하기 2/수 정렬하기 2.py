from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    arr = sorted([int(input()) for _ in range(N)])

    for a in arr:
        print(a)


if __name__ == "__main__":
    solve()
