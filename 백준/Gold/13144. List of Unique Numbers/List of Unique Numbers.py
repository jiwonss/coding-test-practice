from sys import stdin

input = stdin.readline


def solve():
    N = int(input())
    arr = list(map(int, input().split()))

    visited = {}
    left, result = 0, 0

    for right in range(N):
        if arr[right] in visited and visited[arr[right]] >= left:
            left = visited[arr[right]] + 1

        visited[arr[right]] = right
        result += right - left + 1

    print(result)


if __name__ == "__main__":
    solve()
