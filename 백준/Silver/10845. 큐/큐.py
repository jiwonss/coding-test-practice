from sys import stdin
from collections import deque
input = stdin.readline


def solve():
    N = int(input())

    q = deque()
    for _ in range(N):
        op = input().split()
        if op[0] == 'push':
            x = op[1]
            q.append(x)
        elif op[0] == 'pop':
            if q:
                print(q.popleft())
            else:
                print(-1)
        elif op[0] == 'size':
            print(len(q))
        elif op[0] == 'empty':
            if q:
                print(0)
            else:
                print(1)
        elif op[0] == 'front':
            if q:
                print(q[0])
            else:
                print(-1)
        else:
            if q:
                print(q[-1])
            else:
                print(-1)


if __name__ == "__main__":
    solve()
