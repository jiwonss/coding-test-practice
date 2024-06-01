from sys import stdin
input = stdin.readline


def solve():
    n = int(input())
    arr = sorted(list(map(int, input().split())))
    x = int(input())

    result = 0
    start, end = 0, n - 1
    while start < end:
        if arr[start] + arr[end] < x:
            start += 1
        elif arr[start] + arr[end] > x:
            end -= 1
        else:
            start, end = start + 1, end - 1
            result += 1
    print(result)


if __name__ == "__main__":
    solve()
