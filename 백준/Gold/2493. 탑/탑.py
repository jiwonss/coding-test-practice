from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    height = list(map(int, input().split()))

    stack, result = [[-1, 100000001]], []
    for i in range(N):
        h = height[i]
        while stack and stack[-1][1] <= h:
            stack.pop()
        result.append(stack[-1][0] + 1)
        stack.append([i, h])
    print(*result)


if __name__ == "__main__":
    solve()
