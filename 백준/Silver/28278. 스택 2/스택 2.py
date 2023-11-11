from sys import stdin
input = stdin.readline

N = int(input())

stack = []
for _ in range(N):
    op = list(map(int, input().split()))
    if op[0] == 1:
        stack.append(op[1])
    if op[0] == 2:
        if not stack:
            print(-1)
        else:
            print(stack.pop())
    if op[0] == 3:
        print(len(stack))
    if op[0] == 4:
        if not stack:
            print(1)
        else:
            print(0)
    if op[0] == 5:
        if stack:
            print(stack[-1])
        else:
            print(-1)