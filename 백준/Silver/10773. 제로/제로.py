from sys import stdin
input = stdin.readline


def solve():
    K = int(input())

    stack = []
    for _ in range(K):
        n = int(input())
        if n == 0:
            stack.pop()
        else:
            stack.append(n)
    print(sum(stack))


if __name__ == "__main__":
    solve()
