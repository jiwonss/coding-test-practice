from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    arr = list(map(int, input().split()))
    v = int(input())

    result = 0
    for i in range(N):
        if arr[i] == v:
            result += 1
    print(result)


if __name__ == "__main__":
    solve()
