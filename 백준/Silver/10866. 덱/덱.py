from sys import stdin
from collections import deque
input = stdin.readline


def solve():
    N = int(input())

    dq = deque()
    for _ in range(N):
        op = input().split()
        if op[0] == 'push_front':
            x = int(op[1])
            dq.appendleft(x)
        elif op[0] == 'push_back':
            x = int(op[1])
            dq.append(x)
        elif op[0] == 'pop_front':
            if dq:
                print(dq.popleft())
            else:
                print(-1)
        elif op[0] == 'pop_back':
            if dq:
                print(dq.pop())
            else:
                print(-1)
        elif op[0] == 'size':
            print(len(dq))
        elif op[0] == 'empty':
            if dq:
                print(0)
            else:
                print(1)
        elif op[0] == 'front':
            if dq:
                print(dq[0])
            else:
                print(-1)
        else:
            if dq:
                print(dq[-1])
            else:
                print(-1)


if __name__ == "__main__":
    solve()
