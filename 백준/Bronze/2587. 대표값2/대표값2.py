from sys import stdin
input = stdin.readline


def solve():
    arr = sorted([int(input()) for _ in range(5)])
    print(sum(arr) // 5)
    print(arr[2])


if __name__ == "__main__":
    solve()
