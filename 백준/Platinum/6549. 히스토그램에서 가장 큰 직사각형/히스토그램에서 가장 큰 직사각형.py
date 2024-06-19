from sys import stdin
input = stdin.readline


def solve():
    while True:
        temp = list(map(int, input().split()))
        n, h = temp[0], temp[1:]
        if n == 0:
            return

        stack, result = [], 0
        for i in range(n):
            idx = i
            while stack and stack[-1][1] >= h[i]:
                result = max(result, (i - stack[-1][0]) * stack[-1][1])
                idx = stack[-1][0]
                stack.pop()
            stack.append([idx, h[i]])

        while stack:
            result = max(result, (n - stack[-1][0]) * stack[-1][1])
            stack.pop()
        print(result)


if __name__ == "__main__":
    solve()
