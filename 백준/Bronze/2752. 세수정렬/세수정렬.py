from sys import stdin
input = stdin.readline


def solve():
    arr = list(map(int, input().split()))
    print(*sorted(arr))


if __name__ == "__main__":
    solve()
