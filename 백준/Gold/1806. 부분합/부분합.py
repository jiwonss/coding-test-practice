from sys import stdin, maxsize
input = stdin.readline


def solve():
    N, S = map(int, input().split())
    arr = [0] + list(map(int, input().split()))
    for i in range(1, N + 1):
        arr[i] += arr[i - 1]

    left, right = 0, 0
    result = maxsize
    while right <= N:
        v = arr[right] - arr[left]
        if v < S:
            right += 1
        else:
            result = min(result, right - left)
            left += 1
    print(result if result != maxsize else 0)


if __name__ == "__main__":
    solve()
