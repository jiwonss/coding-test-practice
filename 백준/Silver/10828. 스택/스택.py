from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    stack = []
    for _ in range(N):
        op = input().split()
        if op[0] == 'push':
            x = int(op[1])
            stack.append(x)
        elif op[0] == 'pop':
            if stack:
                print(stack.pop())
            else:
                print(-1)
        elif op[0] == 'size':
            print(len(stack))
        elif op[0] == 'empty':
            if stack:
                print(0)
            else:
                print(1)
        else:
            if stack:
                print(stack[-1])
            else:
                print(-1)


if __name__ == "__main__":
    solve()
