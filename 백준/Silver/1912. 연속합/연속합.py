from sys import stdin
input = stdin.readline


def solve():
    n = int(input())
    arr = list(map(int, input().split()))

    for i in range(1, n):
        arr[i] = max(arr[i - 1] + arr[i], arr[i])

    print(max(arr))


if __name__ == "__main__":
    solve()
