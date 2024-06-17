from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    stack, result = [], 0
    for _ in range(N):
        h = int(input())
        cnt = 1
        while stack and stack[-1][1] <= h:
            result += stack[-1][0]
            if stack[-1][1] == h:
                cnt += stack[-1][0]
            stack.pop()
        if stack:
            result += 1
        stack.append([cnt, h])
    print(result)


if __name__ == "__main__":
    solve()
