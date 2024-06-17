from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    stack, result = [], 0
    for _ in range(N):
        h = int(input())
        while stack and stack[-1] <= h:
            stack.pop()
        result += len(stack)
        stack.append(h)
    print(result)


if __name__ == "__main__":
    solve()
