from sys import stdin

input = stdin.readline


def binary_search(n):
    start, end = 0, len(stack)
    while start < end:
        mid = (start + end) // 2
        if stack[mid] < n:
            start = mid + 1
        else:
            end = mid
    return start


def solve():
    global stack

    N = int(input())
    A = list(map(int, input().split()))

    dp, stack = [[0, A[0]]], [A[0]]
    stack, dp = [A[0]], [[0, A[0]]]
    for i in range(1, N):
        if stack[-1] < A[i]:
            stack.append(A[i])
            dp.append([len(stack) - 1, A[i]])
        else:
            idx = binary_search(A[i])
            stack[idx] = A[i]
            dp.append([idx, A[i]])

    max_len = len(stack)
    print(max_len)

    result = []
    idx = max_len - 1
    for i in range(N - 1, -1, -1):
        if dp[i][0] == idx:
            result.append(dp[i][1])
            idx -= 1
    print(*result[::-1])


if __name__ == "__main__":
    solve()
