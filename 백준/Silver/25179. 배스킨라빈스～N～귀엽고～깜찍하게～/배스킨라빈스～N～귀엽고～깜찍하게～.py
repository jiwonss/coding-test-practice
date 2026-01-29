from sys import stdin

input = stdin.readline


def solve():
    N, M = map(int, input().split())
    if (N - 1) % (M + 1) != 0:
        print("Can win")
    else:
        print("Can't win")


if __name__ == "__main__":
    solve()
