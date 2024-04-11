from sys import stdin
input = stdin.readline

N, X = map(int, input().split())
arr = list(map(int, input().split()))


def solve():
    result = []
    for i in range(N):
        if arr[i] < X:
            result.append(arr[i])
    print(*result)


if __name__ == "__main__":
    solve()
